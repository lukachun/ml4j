package net.xsoftlab.ml4j.coursera.ml.ex2;

import java.util.ArrayList;
import java.util.List;

import org.jblas.FloatMatrix;
import org.jblas.MatrixFunctions;

public class MapFeature {

	public static FloatMatrix mapFeature(FloatMatrix X1, FloatMatrix X2) {

		int degree = 6;
		FloatMatrix out;
		List<FloatMatrix> list = new ArrayList<FloatMatrix>();
		for (int i = 1; i <= degree; i++) {
			for (int j = 0; j <= i; j++) {
				list.add(MatrixFunctions.pow(X1, i - j).mul(MatrixFunctions.pow(X2, j)));
			}
		}

		out = new FloatMatrix(X1.rows, list.size() + 1);
		out.putColumn(0, FloatMatrix.ones(X1.length));
		for (int i = 0; i < list.size(); i++) {
			out.putColumn(i + 1, list.get(i));
		}

		return out;
	}
}