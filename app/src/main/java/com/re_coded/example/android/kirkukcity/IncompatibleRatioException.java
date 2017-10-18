package com.re_coded.example.android.kirkukcity;

/**
 * Created by Lenovo on 10/14/2017.
 */


public class IncompatibleRatioException extends RuntimeException {

    private static final long serialVersionUID = 234608108593115395L;

    public IncompatibleRatioException() {
        super("Can't perform Ken Burns effect on rects with distinct aspect ratios!");
    }
}
