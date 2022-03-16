package dhbw.ipoat.computer;

import dhbw.ipoat.medium.Medium;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Computer {
    private float writingSpeed;
    private final float generationSpeed = 0.2f;
    private final List<Medium> mediaInPC = new ArrayList<>();
    private String nameOfPc = "PC-";
    private float puffer;
    private float maxPuffer;
    private final float cost = 2000;
    private float dataTransmitted = 0;

    Instant pcStartTime;

    public Computer() {
        pcStartTime = Instant.now();
        nameOfPc += UUID.randomUUID().toString().substring(0, 8);
    }

    public void GenerateData() {
        Instant newTime = Instant.now();
        Duration time = Duration.between(pcStartTime, newTime);
        puffer = (time.getSeconds() * generationSpeed) - dataTransmitted;
    }

    public Instant getPcStartTime() {
        return pcStartTime;
    }

    public float getPuffer() {
        return puffer;
    }

    public void transferData(Medium medium) {
        GenerateData();
        if (puffer - medium.getData() >= 0 && medium.isFull()) {
            medium.setFull(true);
            dataTransmitted += medium.getData();
        }
        pcStartTime = Instant.now();
    }

    public String getNameOfPc() {
        return nameOfPc;
    }


}
