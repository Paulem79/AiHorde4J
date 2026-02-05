package net.paulem.aihorde4j.client;

/**
 * Callback interface for monitoring generation progress.
 */
@FunctionalInterface
public interface GenerationProgressCallback {
    
    /**
     * Called when the status is updated during polling.
     *
     * @param waitTime Estimated wait time in seconds
     * @param queuePosition Position in the queue
     * @param processing Number of jobs currently processing
     * @param finished Number of jobs finished
     */
    void onProgress(int waitTime, int queuePosition, int processing, int finished);
}
