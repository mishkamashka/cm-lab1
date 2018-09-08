package se.ifmo.ru;

import java.util.HashMap;
import java.util.Map;

public enum InputType {
    CMD_INPUT("0"), FILE_INPUT("1"), RND_INPUT("2");

    private static final Map<String, InputType> MAP = new HashMap<String, InputType>();

    static {
        for (InputType inputType : values()) {
            MAP.put(inputType.getValue(), inputType);
        }
    }

    private String s;

    InputType(String s) {
        this.s = s;
    }

    private String getValue() {
        return s;
    }

    public static InputType getByValue(String s) {
        return MAP.get(s);
    }

}
