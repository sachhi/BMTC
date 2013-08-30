package com.bmtc.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {

    private SlidingPaneLayout mSlidingLayout;
    private ListView mList;
    TextView text_label_1;

    ArrayAdapter<String> leftListAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text_label_1 = (TextView) findViewById(R.id.text_label_1);




        leftListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        leftListAdapter.add("Bus Detail");
        leftListAdapter.add("From To");
        leftListAdapter.add("My Location");

        mSlidingLayout = (SlidingPaneLayout) findViewById(R.id.sliding_pane_layout);
        mList = (ListView) findViewById(R.id.left_pane);

        mSlidingLayout.setPanelSlideListener( new SliderListener());
        //mSlidingLayout.openPane();
        //mSlidingLayout.set

        mList.setAdapter(leftListAdapter);
        mList.setOnItemClickListener(new ListItemClickListener());

    }


    private class SliderListener extends SlidingPaneLayout.SimplePanelSlideListener {

        /**
         * This panel slide listener updates the action bar accordingly for each
         * panel state.
         */

        @Override
        public void onPanelOpened(View panel) {
            //mActionBar.onPanelOpened();
        }

        @Override
        public void onPanelClosed(View panel) {
            //mActionBar.onPanelClosed();
        }
    }



    private class ListItemClickListener implements ListView.OnItemClickListener {

        /**
         * This list item click listener implements very simple view switching by
         * changing the primary content text. The slider is closed when a selection
         * is made to fully reveal the content.
         */

        @SuppressWarnings("deprecation")
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
            mSlidingLayout.smoothSlideClosed();

            //To get value of selected item
            String value = (String)parent.getItemAtPosition(position);

            if(value == "Bus Detail")
            {
                text_label_1.setText("Type   :  ");
            }

            if(value == "From To")
            {

            }

            if(value == "My Location")
            {

            }



        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
