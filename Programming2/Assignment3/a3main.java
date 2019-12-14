public class a3main {
  
 public static double getTotal(double[][] arrayData) {
    double total = 0;

    for (int row = 0; row < arrayData.length; row++) {
        for (int col = 0; col < arrayData[row].length; col++) {
            total += arrayData[row][col];
        }  
    }

    return total;
}

public static double getAverage(double[][] arrayData) {
    return getTotal(arrayData) / getElementCount(arrayData);
}

public static double getRowTotal(double[][] arrayData, int row) {
    double total = 0;

    for (int col = 0; col < arrayData[row].length; col++) {
        total += arrayData[row][col];
    }

    return total;
}

public static double getColumnTotal(double[][] arrayData, int col) {
    double total = 0;

    for (int row = 0; row < arrayData.length; row++) {
        total += arrayData[row][col];
    }

    return total;
}

public static double getHighestInRow(double[][] arrayData, int row) {
    double highest = arrayData[row][0];

    for (int col = 1; col < arrayData[row].length; col++) {
        if (arrayData[row][col] > highest) {
            highest = arrayData[row][col];
        }
    }
    return highest;
}

public static double getLowestInRow(double[][] arrayData, int row) {
    double lowest = arrayData[row][0];

    for (int col = 1; col < arrayData[row].length; col++) {
        if (arrayData[row][col] < lowest) {
            lowest = arrayData[row][col];
        }
    }
    return lowest;
}

public static int getElementCount(double[][] arrayData) {
    int count = 0;

    for (int row = 0; row < arrayData.length; row++) {
        count += arrayData[row].length;
    }
    return count;
}

public static void main(String[] args) {

    double[][] dataSample = { { 1, 2, 3, 4 },{ 4, 3, 2, 1 } };

    System.out.println("Total : " + getTotal(dataSample));
    System.out.println("Average : " + getAverage(dataSample));

    System.out.println("Total row 0 : " + getRowTotal(dataSample, 0));
    System.out.println("Total row 1 : " + getRowTotal(dataSample, 1));

    System.out.println("Total col 0 : " + getColumnTotal(dataSample, 0));
    System.out.println("Total col 1 : " + getColumnTotal(dataSample, 2));

    System.out.println("Highest row 0 : " + getHighestInRow(dataSample, 0));
    System.out.println("Highest row 1 : " + getHighestInRow(dataSample, 1));

    System.out.println("Lowest row 0 : " + getLowestInRow(dataSample, 0));
    System.out.println("Lowest row 1 : " + getLowestInRow(dataSample, 1));
  }
}
