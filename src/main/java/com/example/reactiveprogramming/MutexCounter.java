package com.example.reactiveprogramming;

import lombok.Getter;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.time.LocalDateTime;
import java.util.logging.Logger;

public class MutexCounter {
    // Method to get the current counter value (not thread-safe, just for logging or debugging)
    // The counter value
    @Getter
    private int counter = 0;

    private LocalDateTime firstEntry;

    // Lock to ensure mutual exclusion
    private final ReentrantLock lock = new ReentrantLock();

    // Logger to log the output
    private static final Logger logger = Logger.getLogger(MutexCounter.class.getName());

    // Method to increment the counter in a thread-safe manner
    public void increment() {
        lock.lock(); // Acquire the lock to ensure mutual exclusion
        boolean hasStarted = firstEntry != null;
        if (!hasStarted) {
            firstEntry = LocalDateTime.now();
        }
        try {
            counter++; // Increment the counter
            // Log the current value and the timestamp
            LocalDateTime now = LocalDateTime.now();
            logger.info("Counter incremented to: " + counter + " at " + now + " with time passed = " +
                            ChronoUnit.SECONDS.between(firstEntry, now)
                    );
        } finally {
            lock.unlock(); // Release the lock to allow other threads
        }
    }
}

