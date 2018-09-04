package se.ifmo.ru;

import java.util.List;

public class RandomInput implements Input {

    private int n = 0;

    public List<List<Double>> getInput() {
        n = (int) Math.round(Math.random() * 20);

    }

}
