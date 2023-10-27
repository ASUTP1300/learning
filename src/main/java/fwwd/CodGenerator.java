package fwwd;

import java.util.EnumSet;

public class CodGenerator {
    private final GenerateCodeService javaGenCodeService = JavaGenerateCodeService.getInstance();
    private final GenerateCodeService cppGenCodeService = CppGenerateCodeService.getInstance();
    private final GenerateCodeService phpGenCodeService = PhpGenerateCodeService.getInstance();

    //singleton
    static CodGenerator instance;

    private CodGenerator() {
    }

    public static CodGenerator getInstance() {
        if (instance == null) {
            instance = new CodGenerator();
        }
        return instance;
    }

    public String generateCode(int codeLanguage) {
        Language language = determineLanguage(codeLanguage);
        return generateCodeInternal(language);
    }

    private String generateCodeInternal(Language language) {
        switch (language) {
            case JAVA -> {
                return javaGenCodeService.generate();
            }
            case C_PLUS_PLUS -> {
                return cppGenCodeService.generate();
            }
            case PHP -> {
                return phpGenCodeService.generate();
            }
        }
        throw new RuntimeException("Bad language");
    }

    private Language determineLanguage(int codeLanguage) {
        return EnumSet.allOf(Language.class).stream()
                .filter(l -> l.getValue() == codeLanguage)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No such language"));
    }
}

enum Language {
    JAVA(0),
    C_PLUS_PLUS(1),
    PHP(2);

    private final int value;

    Language(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

interface GenerateCodeService {
    String generate();
}

class JavaGenerateCodeService implements GenerateCodeService {
    private static JavaGenerateCodeService instance;

    private JavaGenerateCodeService() {
    }

    static JavaGenerateCodeService getInstance() {
        if (instance == null) {
            instance = new JavaGenerateCodeService();
        }
        return instance;
    }

    @Override
    public String generate() {
        return "This is Java's code & " + someCodeRelatedThing();
    }

    private String someCodeRelatedThing() {
        return "This is Java's some code related thing";
    }
}

class CppGenerateCodeService implements GenerateCodeService {
    private static CppGenerateCodeService instance;

    private CppGenerateCodeService() {
    }

    static CppGenerateCodeService getInstance() {
        if (instance == null) {
            instance = new CppGenerateCodeService();
        }
        return instance;
    }

    @Override
    public String generate() {
        return "This is Cpp's code & " + someCodeRelatedThing();
    }

    private String someCodeRelatedThing() {
        return "This is Cpp's some code related thing";
    }
}

class PhpGenerateCodeService implements GenerateCodeService {
    private static PhpGenerateCodeService instance;

    private PhpGenerateCodeService() {
    }

    static PhpGenerateCodeService getInstance() {
        if (instance == null) {
            instance = new PhpGenerateCodeService();
        }
        return instance;
    }

    @Override
    public String generate() {
        return "This is Php's code & " + someCodeRelatedThing();
    }

    private String someCodeRelatedThing() {
        return "This is Php's some code related thing";
    }
}