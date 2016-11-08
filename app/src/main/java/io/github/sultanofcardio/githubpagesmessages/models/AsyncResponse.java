package io.github.sultanofcardio.githubpagesmessages.models;

/**
 * @author sultanofcardio
 *
 * Implementing this class allows an Activity class to collect the result of an AsyncTask
 * without needing to pass context or handling view modification restrictions.
 * 
 * You can read more about AsyncTasks here: 
 * https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0ahUKEwiOh73d95nQAhUQ22MKHRtsCkQQFggaMAA&url=https%3A%2F%2Fdeveloper.android.com%2Freference%2Fandroid%2Fos%2FAsyncTask.html&usg=AFQjCNGLaSuxTknRpqLNZwIIM0qNhRQDwA&sig2=pAz-bAlaFNQGKs-QM2GDKQ&bvm=bv.138169073,d.eWE
 *
 * In general, an AsyncTask is a class defined in the android sdk that developers can use
 * to do work in the background. Android applications are multi-threaded but everything that
 * runs in the user interface (i.e. an Activity + an XML layout) is in a single thread called
 * the main thread.
 * 
 * However, we may wish to do some heavy calculations or download some data from the internet
 * that may slow down the user interface if we do them on the main thread. This is exactly what 
 * an AsyncTask can be used for.
 * 
 * This interface exists simple as a convenience method to collect whatever an AsyncTask was working
 * on when it is done and return that data to an Activity class perhaps.
 *
 * This class has been written for you
 */
public interface AsyncResponse {

	/**
	 * This method takes the number of new items found after checking our Flask server
	 * for new messages. It is used in models.MessageTask.java:84
	 * You should implement this interface in activities.MainActivity.java and define this method
	 */
    void processFinish(int newItems);
}
