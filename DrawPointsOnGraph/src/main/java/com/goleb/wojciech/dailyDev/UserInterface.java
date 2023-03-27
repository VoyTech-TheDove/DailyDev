package com.goleb.wojciech.dailyDev;

import com.goleb.wojciech.Input;

public class UserInterface {
    private final static int minPoints = 0;
    private final static int maxPoints = 5;
    private final static int minXCoordinate = 1;
    private final static int maxXCoordinate = 10;
    private final static int minYCoordinate = 1;
    private final static int maxYCoordinate = 10;
    DrawPointsOnGraph drawPointsOnGraph = new DrawPointsOnGraph();

    public void start() {
        drawPointsOnGraph.createGraph();
        greetings();
        int pointsNumber = askForNumberOfPoints();
        askForPointsAndAddThem(pointsNumber);
        drawPointsOnGraph.printGraph();
    }

    private void askForPointsAndAddThem(int pointsNumber) {
        for (int i = 0; i < pointsNumber; i++) {
            System.out.println("Please enter X of the " + (i + 1) + " point [" + minXCoordinate + "-" + maxXCoordinate + "]");
            int x = getXtoYfromUser(minXCoordinate, maxXCoordinate);
            System.out.println("Please enter Y of the " + (i + 1) + " point [" + minYCoordinate + "-" + maxYCoordinate + "]");
            int y = getXtoYfromUser(minYCoordinate, maxYCoordinate);
            drawPointsOnGraph.addPointToGraph(x, y);
        }
    }

    private int askForNumberOfPoints() {
        System.out.println("How many points would you like to show on graph [ " + minPoints + " to " + maxPoints + " ]");
        return getXtoYfromUser(minPoints, maxPoints);
    }

    private int getXtoYfromUser(int x, int y) {
        int number = Input.getIntFromUser();
        if (number < x || number > y) {
            return 0;
        }
        return number;
    }

    private void greetings() {
        System.out.println("hello, I'm going to print a graph with your points on it");
    }
}
