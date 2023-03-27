package com.goleb.wojciech.dailyDev;

public class DrawPointsOnGraph {
    final Object[][] graph = new String[11][11];

    public void createGraph() {
        for (int i = 0; i < 10; i++) {
            graph[i][0] = "|";
        }
        for (int j = 1; j < 11; j++) {
            graph[10][j] = "-";
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 11; j++) {
                graph[i][j] = "";
            }
        }
        graph[10][0] = "+";
    }

    public void addPointToGraph(int x, int y) {
        graph[10 - y][x] = "X";
    }

    public void printGraph() {
        for (final Object[] row : graph) {
            System.out.format("%2s%2s%2s%2s%2s%2s%2s%2s%2s%2s%2s%n", row);
        }
    }
}
