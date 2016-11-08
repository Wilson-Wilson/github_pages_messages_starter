package io.github.sultanofcardio.githubpagesmessages.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;

import io.github.sultanofcardio.githubpagesmessages.R;
import io.github.sultanofcardio.githubpagesmessages.models.AsyncResponse;

/**
 * This is an Activity class. At this point, an activity is just a representation
 * of a single screen in our Android App. It has a lifecycle and a user
 * interface that we can manipulate. In the spirit of separation of concerns, 
 * the user interface is specified in a separate file called activity_main.xml.
 *
 * The android operating system is responsible for managing the lifecycle of 
 * our app and when a user clicks on the app icon, it starts that management by
 * manipulating activities (such as this class), until the app dies (killed by 
 * the OS or the user exits).
 *
 * How does it manipulate activies? It does so by calling the following methods:
 *
 * onCreate()
 * onStart()
 * onResume()
 * onPause()
 * onStop()
 * onDestoy()
 *
 * which are defined in the parent class AppCompatActivity (more on this later!).
 *
 * This is the android activity lifecycle in a nutshell. You can find out more 
 * about that here:
 * https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0ahUKEwjZ9dXU_pnQAhVDzGMKHWFzCzIQFggaMAA&url=https%3A%2F%2Fdeveloper.android.com%2Ftraining%2Fbasics%2Factivity-lifecycle%2Findex.html&usg=AFQjCNFlcWWid-ENI1MzFNEfDK-8srWePA&sig2=rl5Efy8X_xhNG-cxaHRBEg&bvm=bv.138169073,d.eWE
 *
 * The good news is that these are all methods we can override! such as on line 58 
 * of this class where we override the onCreate() method. This is the first method 
 * in the lifecycle and so is an ideal place to put some code that we want to be 
 * run when the activity is created by the OS. This is the only lifecycle method we
 * override in this activity but sometimes it may be convenient to override more.
 *
 * Feel free to use Google, Stack Overflow and any other resource (maybe even me) to 
 * help you with this project.
 *
 */
public class MainActivity extends AppCompatActivity
implements SwipeRefreshLayout.OnRefreshListener, AsyncResponse{
    /*
    Place your references to the views in the xml file and other variables here as 
    member variables. All the xml views have been done up for you.
    */
    RelativeLayout relativeLayout;
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*

        Call the methods we defined below (such as createDialog()) here. We use methods 
        instead of writing code directly here for better readability

        This is a general rundown of what we hope to achieve here. You can assume
        a 1:1 ratio between the steps below and the methods we defined:

        1. Initialize/obtain reference to the views for the first time. This is done
            for obvious reasons.
        2. Check if the app is being launched for the first time:
            a. If it is, create a dialog
            b. Else, set up the views that will be shown in the activity
        3. Execute an instance of the asynctask MessageTask.java using the execute() 
           method. This starts the process of checking our Flask server for the messages
           we'll need.

        */
    }

    private void createDialog(){
        /*
        Create an instance of an alert dialog with an EditText to collect the server 
        URL then store the URL for later, then show the dialog. You should use the 
        dialog_add_url.xml as the view for the dialog.

        An alert dialog is a class available in the android sdk that allows us to show
        a quick dialog over our current activity (such as to confirm an action) without 
        having to use a completely different activity, so it's convenient.

        Once you create an instance of the alert dialog, you can use its methods to do
        what is described above. You can read more about the alert dialog here:
        https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=2&cad=rja&uact=8&ved=0ahUKEwj9s8XagZrQAhVGxWMKHVr1ACoQFgggMAE&url=https%3A%2F%2Fdeveloper.android.com%2Freference%2Fandroid%2Fapp%2FAlertDialog.html&usg=AFQjCNEcOVs0zO2--SEMdttH1OBvva7rKA&sig2=uyljFfNXijESSrQVnFgbdw&bvm=bv.138169073,d.eWE

        Set an onclicklistener on your alertdialog and insert the following code stub in
        this onClick method:

            SharedPreferences preferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("server_url", urlValue.getText().toString());
            editor.apply();

            setUpViews();
            new MessageTask(MainActivity.this, MainActivity.this).execute();
        */
    }

    private boolean isFirstTime() {
        /*
        
        Check if the app has been run before and return the value as a boolean.
        I recommend using SharedPreferenced (as demonstrated above) but you may 
        use a more convenient method, if there is one.

        A SharedPreference value is a value in a xml file managed by our app. It is
        normally used for the settings part of an app but it can apply elsewhere, 
        such as here. We can set a value in shared preferences the first time the 
        app is run, and that value will always exist unless the app is uninstalled 
        or the user clears the data (which is technically the same thing). This is 
        a good way to check if the app is being run for the first time because if 
        it hadn't, the value for the shared preference wouldn't exist (save the 
        exceptions above).

        */

        return false;
    }

    private void initViews(){
        /*
        
        Simple initialize your member variable here. Some of them will be refereces
        to views in the xml file, which you can instantiate using the findViewById()
        method. This method returns a view so you may have to cast it. 
        One has been done for you.

        */

        relativeLayout = (RelativeLayout) findViewById(R.id.no_messages);
    }

    private void setUpViews(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.activity_main_label));

        swipe.setOnRefreshListener(this);

        // Call the setUpRecyclerView() method below


    }

    private void setUpRecyclerView(){
        /*
        
        We make use of a RecyclerView in this activity which is a class provided by the 
        android sdk that is well adapted to displaying various types of lists. We will be
        using it to display a simple vertical text list. It can be a very difficult or 
        quite easy interface to use depending on how much you know about it, so I 
        recommend reading these resources:
        https://developer.android.com/training/material/lists-cards.html
        https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=1&cad=rja&uact=8&ved=0ahUKEwijitX7hprQAhWHLmMKHU9GDTQQFggaMAA&url=https%3A%2F%2Fdeveloper.android.com%2Freference%2Fandroid%2Fsupport%2Fv7%2Fwidget%2FRecyclerView.html&usg=AFQjCNGX59895iIU1mqDiO6qNJ-c-_SlGA&sig2=OfSHMQL-sNRSVilib3Y0OQ&bvm=bv.138169073,d.eWE

        We won't be doing anything too complex so the following should be sufficient for our
        project. To successfully set up a recyclerview, several things need to be done:

        1. Obtain a reference to it (which we would have already done)
        2. Set a layout manager on it using the setLayoutManager() method. This informs
        the RecyclerView how it should display the list of data. Use a LinearLayoutManager
        3. Set an adapter on it using the setAdapter() method. Your adapter should be an 
        instance of the RecyclerView.Adapter<VH> class. One of these is provided for you as 
        adapters.MessageAdapter.java

        */

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, true);
        manager.setStackFromEnd(true);

        /* Insert your code here */

        recyclerView.setHasFixedSize(true);
        recyclerView.addOnChildAttachStateChangeListener(new RecyclerView.OnChildAttachStateChangeListener() {
            @Override
            public void onChildViewAttachedToWindow(View view) {
                if(recyclerView.getChildCount() > 0)
                    relativeLayout.setVisibility(View.GONE);
            }

            @Override
            public void onChildViewDetachedFromWindow(View view) {
                if(recyclerView.getChildCount() == 0)
                    relativeLayout.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void onRefresh() {
        /*

        This activity implements the SwipeRefreshLayout.OnRefreshListener interface
        and as such, must define the onRefresh() method. A SwipeRefreshLayout is just 
        a view that allows a user to swipe down gesture in our app to trigger some action. 

        We react to this swipe gesture in this onRefresh() method. For this activity, 
        we will want to check to see if there are any new messages on our Flask server
        and display them, if any (which is what the user expects). We do this by executing 
        a new asynctask below.

        */
    }

    @Override
    public void processFinish(int newItems) {
        /*

        Check if there are any new items. If there are, 
        call the update() method on the adapter.

        */
    }
}
