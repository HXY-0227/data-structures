package com.graph;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 邻接矩阵表示方法
 *
 * @author : HXY
 * @date : 2021-07-12 21:44
 **/
public class AdjMatrix implements Graph{

    // 顶点数
    private int vertex;
    // 边数
    private int edge;
    // 二维数组表示邻接矩阵
    private int[][] adj;

    public AdjMatrix(String fileName) {
        buildGraph(fileName);
    }

    @Override
    public void buildGraph(String fileName) {
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            vertex = scanner.nextInt();
            edge = scanner.nextInt();
            adj = new int[vertex][vertex];

            for (int i = 0; i < edge; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                adj[a][b] = 1;
                adj[b][a] = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getVertex() {
        return vertex;
    }

    @Override
    public int getEdge() {
        return edge;
    }

    @Override
    public boolean isAdjacent(int inputVertex1, int inputVertex2) {
        return adj[inputVertex1][inputVertex2] == 1;
    }

    @Override
    public Iterator<Integer> getAdjacentVertex(int inputVertex) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < vertex; i++) {
            if (adj[inputVertex][i] == 1) {
                result.add(i);
            }
        }
        return result.iterator();
    }

    @Override
    public int degree(int inputVertex) {
        int degree = 0;
        for (int i = 0; i < vertex; i++) {
            if (adj[inputVertex][i] == 1) {
                degree++;
            }
        }
        return degree;
    }

    @Override
    public Iterator<Integer> dfs() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("v = %d, e = %d %n", vertex, edge));
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                sb.append(String.format("%d ", adj[i][j]));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
