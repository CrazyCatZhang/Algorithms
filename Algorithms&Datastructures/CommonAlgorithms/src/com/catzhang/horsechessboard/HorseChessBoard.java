package com.catzhang.horsechessboard;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: crazycatzhang
 * @date: 2020/8/8 12:08 PM
 * @description: Solve the problem of horse stepping on the chessboard by Floyd algorithm
 */
public class HorseChessBoard {
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        int[][] chessBoard1 = chessBoard.chessBoard;
        Horse horse = new Horse();
        horse.floyd(chessBoard1, 0, 0, 1);
        for (int[] step :
                chessBoard1) {
            System.out.println(Arrays.toString(step));
        }
    }
}

//Creat ChessBoard
class ChessBoard {
    public static final int X = 8;
    public static final int Y = 8;

    public int[][] chessBoard;

    public ChessBoard() {
        this.chessBoard = new int[this.Y][this.X];
    }
}

//Creat Horse
class Horse {
    public boolean[][] isVisited;
    public boolean finished;

    public Horse() {
        this.isVisited = new boolean[ChessBoard.Y][ChessBoard.X];
        this.finished = false;
    }

    //Get all the positions where the current horse can go
    public ArrayList<Point> nextPoint(Point currentPoint) {
        ArrayList<Point> points = new ArrayList<>();
        Point point = new Point();
        if ((point.x = currentPoint.x - 2) >= 0 && (point.y = currentPoint.y - 1) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = currentPoint.x - 1) >= 0 && (point.y = currentPoint.y - 2) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = currentPoint.x + 1) < ChessBoard.X && (point.y = currentPoint.y - 2) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = currentPoint.x + 2) < ChessBoard.X && (point.y = currentPoint.y - 1) >= 0) {
            points.add(new Point(point));
        }
        if ((point.x = currentPoint.x + 2) < ChessBoard.X && (point.y = currentPoint.y + 1) < ChessBoard.Y) {
            points.add(new Point(point));
        }
        if ((point.x = currentPoint.x + 1) < ChessBoard.X && (point.y = currentPoint.y + 2) < ChessBoard.Y) {
            points.add(new Point(point));
        }
        if ((point.x = currentPoint.x - 1) >= 0 && (point.y = currentPoint.y + 2) < ChessBoard.Y) {
            points.add(new Point(point));
        }
        if ((point.x = currentPoint.x - 2) >= 0 && (point.y = currentPoint.y + 1) < ChessBoard.Y) {
            points.add(new Point(point));
        }
        return points;
    }

    //Define Floyd method
    public void floyd(int[][] chessBoard, int row, int column, int step) {
        chessBoard[row][column] = step;
        this.isVisited[row][column] = true;
        ArrayList<Point> points = nextPoint(new Point(column, row));
        points.sort(Comparator.comparingInt(o -> nextPoint(o).size()));
        while (!points.isEmpty()) {
            Point point = points.remove(0);
            if (!this.isVisited[point.y][point.x]) {
                floyd(chessBoard, point.y, point.x, step + 1);
            }
        }
        if (step < ChessBoard.X * ChessBoard.Y && !this.finished) {
            chessBoard[row][column] = 0;
            this.isVisited[row][column] = false;
        } else {
            this.finished = true;
        }
    }
}
