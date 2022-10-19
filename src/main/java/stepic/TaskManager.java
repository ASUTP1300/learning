package stepic;

import java.util.*;
import java.util.function.Supplier;

class TaskManager {
    /**
     * Highest priority queues come first in the list.
     * The 0th queue contains tasks with the highest priority.
     */
    private final List<Queue<Task>> taskQueues = new ArrayList<>();

    public TaskManager(int numberOfQueues) {
        if (numberOfQueues < 1) {
            throw new IllegalArgumentException("The number of queues must be >= 1");
        }
        for (int i = 0; i < numberOfQueues; i++) {
            taskQueues.add(new ArrayDeque<>());
        }
    }

    public void add(Task task, int priority) {
        if (priority < 0 || priority >= taskQueues.size()) {
            throw new IllegalArgumentException("The task has an illegal priority " + priority);
        }
        taskQueues.get(priority).add(task);
    }

    /**
     * Returns a supplier to access tasks in the right order according to their priority.
     * If all the queues are empty, it returns null.
     */
    public Supplier<Task> getTaskSupplier() {
        //return () -> null; // write your code here
//        for(Queue<Task> queue : taskQueues){
//            return queue::poll;
//        }
//
//        return () -> {
//            for(Queue<Task> queue : taskQueues){
//                return queue.poll();
//            }
//        }
//
//

//        ArrayDeque<Queue<Task>> dequeQueue = new ArrayDeque<>(taskQueues);
//        return () -> {
//            while (!dequeQueue.isEmpty()) {
//                if (!dequeQueue.peek().isEmpty()) {
//                    return dequeQueue.peek().poll();
//                }
//                dequeQueue.poll();
//            }
//            return null;
//        };


        return () -> {
            taskQueues.removeIf(x -> x.peek() == null);
            return taskQueues.isEmpty() ? null : taskQueues.get(0).poll();
        };


    }
}

    class Task {
        private final long number;
        private final int priority;

        public Task(long number, int priority) {
            this.number = number;
            this.priority = priority;
        }

        public long getNumber() {
            return number;
        }

        public int getPriority() {
            return priority;
        }
    }

    class TasksHandling {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int numberOfQueues = Integer.parseInt(scanner.nextLine());
            int numberOfTasks = Integer.parseInt(scanner.nextLine());

            TaskManager manager = new TaskManager(numberOfQueues);

            for (int i = 0; i < numberOfTasks; i++) {
                String[] taskParts = scanner.nextLine().split("\\s+");
                long number = Long.parseLong(taskParts[0]);
                int priority = Integer.parseInt(taskParts[1]);
                Task task = new Task(number, priority);
                manager.add(task, priority);
            }

            Supplier<Task> taskSupplier = manager.getTaskSupplier();
            Task task;
            while ((task = taskSupplier.get()) != null) {
                System.out.println(task.getNumber());
            }
        }
    }
