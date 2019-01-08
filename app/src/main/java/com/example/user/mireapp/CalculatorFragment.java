package com.example.user.mireapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalculatorFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public CalculatorFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static CalculatorFragment newInstance(String param1, String param2) {
        CalculatorFragment fragment = new CalculatorFragment();
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

    TextView tvResult, tvSecond, tvSymbol;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calculator, container, false);

        Button btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine, btnZero,
                btnUmnojenie, btnDelenie, btnSlojenie, btnVichitanie, btnDot, btnResult, btnClear;
        ImageButton btnBack;

        tvResult = view.findViewById(R.id.tvResult);
        tvSecond = view.findViewById(R.id.tvSecond);
        tvSymbol = view.findViewById(R.id.tvSymbol);

        btnOne = view.findViewById(R.id.btnOne);
        btnTwo = view.findViewById(R.id.btnTwo);
        btnThree = view.findViewById(R.id.btnThree);
        btnFour = view.findViewById(R.id.btnFour);
        btnFive = view.findViewById(R.id.btnFive);
        btnSix = view.findViewById(R.id.btnSix);
        btnSeven = view.findViewById(R.id.btnSeven);
        btnEight = view.findViewById(R.id.btnEight);
        btnNine = view.findViewById(R.id.btnNine);
        btnZero = view.findViewById(R.id.btnZero);
        btnUmnojenie = view.findViewById(R.id.btnUmnojenie);
        btnDelenie = view.findViewById(R.id.btnDelenie);
        btnSlojenie = view.findViewById(R.id.btnSlojenie);
        btnVichitanie = view.findViewById(R.id.btnVichitanie);
        btnDot = view.findViewById(R.id.btnDot);
        btnResult = view.findViewById(R.id.btnResult);
        btnBack = view.findViewById(R.id.btnBack);
        btnClear = view.findViewById(R.id.btnClear);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
        btnFour.setOnClickListener(this);
        btnFive.setOnClickListener(this);
        btnSix.setOnClickListener(this);
        btnSeven.setOnClickListener(this);
        btnEight.setOnClickListener(this);
        btnNine.setOnClickListener(this);
        btnZero.setOnClickListener(this);
        btnUmnojenie.setOnClickListener(this);
        btnDelenie.setOnClickListener(this);
        btnSlojenie.setOnClickListener(this);
        btnVichitanie.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnBack.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        String strResult = tvResult.getText().toString();
        String strSecond = tvSecond.getText().toString();
        String strSymbol = tvSymbol.getText().toString();
        switch (view.getId()) {
            case R.id.btnClear:
                tvSecond.setText("");
                tvResult.setText("");
                tvSymbol.setText("");
                break;
            case R.id.btnBack:

                if (!strResult.isEmpty()) {
                    tvResult.setText(strResult.substring(0, strResult.length() - 1));
                }
                break;
            case R.id.btnOne:
                tvResult.append("1");
                break;
            case R.id.btnTwo:
                tvResult.append("2");
                break;
            case R.id.btnThree:
                tvResult.append("3");
                break;
            case R.id.btnFour:
                tvResult.append("4");
                break;
            case R.id.btnFive:
                tvResult.append("5");
                break;
            case R.id.btnSix:
                tvResult.append("6");
                break;
            case R.id.btnSeven:
                tvResult.append("7");
                break;
            case R.id.btnEight:
                tvResult.append("8");
                break;
            case R.id.btnNine:
                tvResult.append("9");
                break;
            case R.id.btnZero:
                tvResult.append("0");
                break;
            case R.id.btnDot:
                if ((!strResult.isEmpty()) && (strResult.indexOf(".") == -1)) {
                    char symbol = strResult.charAt(strResult.length() - 1);
                    if (symbol == 42 || symbol == 43 || symbol == 45 || symbol == 46 || symbol == 47) {
                        tvResult.setText(strResult.substring(0, strResult.length() - 1));
                    }
                    tvResult.append(".");
                }
                break;
            case R.id.btnDelenie:
                if (!(strSecond.isEmpty()) && !(strResult.isEmpty()) &&
                        (strSymbol.equals("-") || strSymbol.equals("+") || strSymbol.equals("/") || strSymbol.equals("*"))) {
                    tvSecond.setText(strSecond.concat(strSymbol).concat(strResult));
                    try {
                        double resultForTVSecond = 1;
                        if (strSymbol.equals("+")) {
                            resultForTVSecond = Double.valueOf(strSecond) + Double.valueOf(strResult);
                        } else if (strSymbol.equals("-")) {
                            resultForTVSecond = Double.valueOf(strSecond) - Double.valueOf(strResult);
                        } else if (strSymbol.equals("/")) {
                            if (strResult.equals("0")) {
                                Log.d("Egor", strResult + " / " + strSecond);
                                throw new ArithmeticException();
                            } else {
                                resultForTVSecond = Double.valueOf(strSecond) / Double.valueOf(strResult);
                            }

                        } else if (strSymbol.equals("*")) {
                            resultForTVSecond = Double.valueOf(strSecond) * Double.valueOf(strResult);
                        }
                        tvSecond.setText(String.valueOf(resultForTVSecond));
                        tvSymbol.setText("/");
                        tvResult.setText("");


                    } catch (ArithmeticException e) {
                        tvResult.setText("");
                    }

                } else if (!strResult.isEmpty() || !strSecond.isEmpty()) {

                    if (!strResult.isEmpty()) {
                        tvSecond.setText(tvResult.getText().toString());
                    }
                    tvSymbol.setText("/");
                    tvResult.setText("");
                }
                break;
            case R.id.btnUmnojenie:
                if (!(strSecond.isEmpty()) && !(strResult.isEmpty()) &&
                        (strSymbol.equals("-") || strSymbol.equals("+") || strSymbol.equals("/") || strSymbol.equals("*"))) {
                    tvSecond.setText(strSecond.concat(strSymbol).concat(strResult));
                    try {
                        double resultForTVSecond = 1;
                        if (strSymbol.equals("+")) {
                            resultForTVSecond = Double.valueOf(strSecond) + Double.valueOf(strResult);
                        } else if (strSymbol.equals("-")) {
                            resultForTVSecond = Double.valueOf(strSecond) - Double.valueOf(strResult);
                        } else if (strSymbol.equals("/")) {
                            if (strResult.equals("0")) {
                                Log.d("Egor", strResult + " / " + strSecond);
                                throw new ArithmeticException();
                            } else {
                                resultForTVSecond = Double.valueOf(strSecond) / Double.valueOf(strResult);
                            }

                        } else if (strSymbol.equals("*")) {
                            resultForTVSecond = Double.valueOf(strSecond) * Double.valueOf(strResult);
                        }
                        tvSecond.setText(String.valueOf(resultForTVSecond));
                        tvSymbol.setText("*");
                        tvResult.setText("");


                    } catch (ArithmeticException e) {
                        tvResult.setText("");
                    }

                } else if (!strResult.isEmpty() || !strSecond.isEmpty()) {

                    if (!strResult.isEmpty()) {
                        tvSecond.setText(tvResult.getText().toString());
                    }
                    tvSymbol.setText("*");

                    tvResult.setText("");
                }
                break;
            case R.id.btnSlojenie:
                if (!(strSecond.isEmpty()) && !(strResult.isEmpty()) &&
                        (strSymbol.equals("-") || strSymbol.equals("+") || strSymbol.equals("/") || strSymbol.equals("*"))) {
                    tvSecond.setText(strSecond.concat(strSymbol).concat(strResult));
                    try {
                        double resultForTVSecond = 1;
                        if (strSymbol.equals("+")) {
                            resultForTVSecond = Double.valueOf(strSecond) + Double.valueOf(strResult);
                        } else if (strSymbol.equals("-")) {
                            resultForTVSecond = Double.valueOf(strSecond) - Double.valueOf(strResult);
                        } else if (strSymbol.equals("/")) {
                            if (strResult.equals("0")) {
                                Log.d("Egor", strResult + " / " + strSecond);
                                throw new ArithmeticException();
                            } else {
                                resultForTVSecond = Double.valueOf(strSecond) / Double.valueOf(strResult);
                            }

                        } else if (strSymbol.equals("*")) {
                            resultForTVSecond = Double.valueOf(strSecond) * Double.valueOf(strResult);
                        }
                        tvSecond.setText(String.valueOf(resultForTVSecond));
                        tvSymbol.setText("+");
                        tvResult.setText("");


                    } catch (ArithmeticException e) {
                        tvResult.setText("");
                    }

                } else if (!strResult.isEmpty() || !strSecond.isEmpty()) {

                    if (!strResult.isEmpty()) {
                        tvSecond.setText(tvResult.getText().toString());
                    }
                    tvSymbol.setText("+");

                    tvResult.setText("");
                }
                break;
            case R.id.btnVichitanie:
                if ((strResult.isEmpty()) && (strSecond.isEmpty())) {
                    tvSecond.setText("0");
                    tvSymbol.setText("-");
                } else if (!(strSecond.isEmpty()) && !(strResult.isEmpty()) &&
                        (strSymbol.equals("-") || strSymbol.equals("+") || strSymbol.equals("/") || strSymbol.equals("*"))) {
                    tvSecond.setText(strSecond.concat(strSymbol).concat(strResult));
                    try {
                        String symbol;
                        double resultForTVSecond = 1;
                        symbol = tvSymbol.getText().toString();
                        if (symbol.equals("+")) {
                            resultForTVSecond = Double.valueOf(strSecond) + Double.valueOf(strResult);
                        } else if (symbol.equals("-")) {
                            resultForTVSecond = Double.valueOf(strSecond) - Double.valueOf(strResult);
                        } else if (symbol.equals("/")) {
                            if (strResult.equals("0")) {
                                Log.d("Egor", strResult + " / " + strSecond);
                                throw new ArithmeticException();
                            } else {
                                resultForTVSecond = Double.valueOf(strSecond) / Double.valueOf(strResult);
                            }

                        } else if (symbol.equals("*")) {
                            resultForTVSecond = Double.valueOf(strSecond) * Double.valueOf(strResult);
                        }
                        tvSecond.setText(String.valueOf(resultForTVSecond));
                        tvSymbol.setText("-");
                        tvResult.setText("");


                    } catch (ArithmeticException e) {
                        tvResult.setText("");
                    }

                } else if (!strResult.isEmpty() || !strSecond.isEmpty()) {

                    tvSymbol.setText("-");
                    if (!strResult.isEmpty()) {
                        tvSecond.setText(tvResult.getText().toString());
                    }
                    tvResult.setText("");
                }
                break;
            case R.id.btnResult:
                try {
                    String symbol, textForTVSecond;
                    double result = 1;
                    symbol = tvSymbol.getText().toString();

                    if (!strResult.isEmpty()) {
                        textForTVSecond = strSecond.concat(symbol.concat(strResult));
                        if (symbol.equals("+")) {
                            result = Double.valueOf(strSecond) + Double.valueOf(strResult);
                        } else if (symbol.equals("-")) {
                            result = Double.valueOf(strSecond) - Double.valueOf(strResult);
                        } else if (symbol.equals("/")) {
                            if (strResult.equals("0")) {
                                Log.d("Egor", strResult + " / " + strSecond);
                                throw new ArithmeticException();
                            } else {
                                result = Double.valueOf(strSecond) / Double.valueOf(strResult);
                            }

                        } else if (symbol.equals("*")) {
                            result = Double.valueOf(strSecond) * Double.valueOf(strResult);
                        } else if (symbol.equals("=")) {
                            result = Double.valueOf(strResult);
                            textForTVSecond = String.valueOf(result);
                        }
                        tvSecond.setText(textForTVSecond);
                        tvSymbol.setText("=");
                        tvResult.setText(String.valueOf(result));
                    }
                } catch (ArithmeticException e) {
                    tvResult.setText("");
                }
                break;
        }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
