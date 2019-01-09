package com.example.user.mireapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class GoogleMapsFragment extends Fragment implements OnMapReadyCallback {

    MapView map;
    private GoogleMap googleMap;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public GoogleMapsFragment() {
        // Required empty public constructor
    }

    public static GoogleMapsFragment newInstance(String param1, String param2) {
        GoogleMapsFragment fragment = new GoogleMapsFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_google_maps, container, false);
        map = (MapView) view.findViewById(R.id.mapView);
        map.onCreate(savedInstanceState);
        map.onResume();
        map.getMapAsync(this);
        return view;
    }

    @Override
    public void onMapReady(GoogleMap gm) {

        googleMap = gm;
        LatLng markerMIREA = new LatLng(55.670005, 37.479894);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(markerMIREA).zoom(15).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        googleMap.addMarker(new MarkerOptions().position(markerMIREA).title("МИРЭА"));
        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View view = getLayoutInflater().inflate(R.layout.snippet_for_maps, null);
                TextView tvName, tvYear, tvAdres, tvCoord;
                tvName = (TextView) view.findViewById(R.id.tvForMapsName);
                tvYear = (TextView) view.findViewById(R.id.tvForMapsYear);
                tvAdres = (TextView) view.findViewById(R.id.tvForMapsAdress);
                tvCoord = (TextView) view.findViewById(R.id.tvForMapsCoord);

                LatLng ll = marker.getPosition();
                tvName.setText(marker.getTitle()+". Крупнейший политехнический ВУЗ.");
                tvYear.setText("Год основания 28 мая 1947 г.");
                tvAdres.setText("Адрес: Проспект Вернадского, 78");
                tvCoord.setText("Координаты: " + String.valueOf(ll.latitude) + ", "+ String.valueOf(ll.longitude));

                return view;
            }
        });
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
    }

    @Override
    public void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        map.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        map.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        map.onLowMemory();
    }

}
