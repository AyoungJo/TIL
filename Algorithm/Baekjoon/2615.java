//2615 - 오목
//8방향 탐색

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   static int N;
   static int input[][];

   static int dx[] = { -1, 0, 1, 1 }; // 우상, 우, 우하, 하
   static int dy[] = { 1, 1, 1, 0 }; // 우상, 우, 우하, 하

   public static boolean check(int x, int y) {
      if (x < 0 || y < 0 || x >= N || y >= N) {
         return false;
      }

      return true;
   }

   public static boolean checkPlayer(int x, int y, int player) {
      if ((check(x, y)) && (input[x][y] == player)) {
         return true;
      }

      return false;
   }

   public static int checkOmok(int x, int y) {
      int nowPlayer = input[x][y];

      if (nowPlayer == 0) {
         return 0;
      }

      for (int d = 0; d < 4; d++) {
         int nx = x;
         int ny = y;

         boolean flag = true;

         for (int c = 0; c < 4; c++) {
            nx = nx + dx[d];
            ny = ny + dy[d];

            if (!checkPlayer(nx, ny, nowPlayer)) {
               flag = false;
               break;
            }
         }

         if (flag == true) {
            if (checkPlayer(nx + dx[d], ny + dy[d], nowPlayer)) { 
               flag = false;
               continue;
            }

            if (checkPlayer(x - dx[d], y - dy[d], nowPlayer)) { 
               flag = false;
               continue;
            }

            return nowPlayer;
         }
      }

      return 0;
   }

   public static void main(String[] args) throws IOException {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

      N = 19;
      input = new int[N][N];
      for (int i = 0; i < N; i++) {
         StringTokenizer token = new StringTokenizer(bf.readLine());

         for (int j = 0; j < N; j++) {
            input[i][j] = Integer.parseInt(token.nextToken());
         }
      }

      for (int r = 0; r < N; r++) {
         for (int c = 0; c < N; c++) {
            int winner = checkOmok(r, c);
            if (winner != 0) {
               System.out.println(winner);
               System.out.println((r + 1) + " " + (c + 1));

               return;
            }
         }
      }

      System.out.println(0);
   }
}
