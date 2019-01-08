package com.example.user.mireapp;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;


public class BrowserFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public BrowserFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static BrowserFragment newInstance(String param1, String param2) {
        BrowserFragment fragment = new BrowserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    WebView webView1;
    EditText etSearch;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_browser, container, false);

        Button btnBack = (Button) view.findViewById(R.id.btnFragmentBrowserBack);
        Button btnGo = (Button) view.findViewById(R.id.btnFragmentBrowserGoToUrl);
        etSearch = (EditText) view.findViewById(R.id.etFragmentBrowserSearch);

        webView1 = (WebView) view.findViewById(R.id.webView1);
        webView1.getSettings().setJavaScriptEnabled(true);
        webView1.setWebViewClient(new MyWebViewClient());
        webView1.loadUrl("https://mail.ru/");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(webView1.canGoBack()){
                    webView1.goBack();
                }
            }
        });
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = etSearch.getText().toString();
                if(url.length() != 0){
                    if((!url.startsWith("https://"))||(!url.startsWith("http://"))){
                        url = "https://"+url;
                    }
                    webView1.loadUrl(url);
                }
            }
        });
        return view;
    }


}
