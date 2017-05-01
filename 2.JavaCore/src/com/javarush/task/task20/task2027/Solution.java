package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        List<Word> words = detectAllWords(crossword, "home", "same");
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i));
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> listWords = new ArrayList<> ( );
        int        N         = crossword.length;// number of rows
        int        M         = crossword[0].length;// number of columns
        String     sN;
        for (String s : words)
        {
            int lnWord = s.length ( );
            for (int i = 0; i < N; i++)//  by rows from left to right
            {
                for (int j = 0; j < M; j++)// by columns
                {
                    sN = makeStringR (j, i, lnWord,  crossword);
                    if ((s.equals (sN)))
                        listWords.add (makeWord (sN, j, i, j + lnWord - 1, i));
                    //--------------------------------------------------
                    sN = makeStringL (j, i, lnWord, crossword);
                    if (s.equals (sN))
                        listWords.add (makeWord (sN, j, i, j - lnWord + 1, i));
                    //--------------------------------------------------
                    sN = makeStringUp (j, i, lnWord, crossword);
                    if (s.equals (sN))
                        listWords.add (makeWord (sN, j, i, j, i - lnWord + 1));
                    //--------------------------------------------------
                    sN = makeStringDown (j, i, lnWord, crossword);
                    if (s.equals (sN))
                        listWords.add (makeWord (sN, j, i, j, i + lnWord - 1));
                    //--------------------------------------------------
                    sN = makeStringUpL (j, i, lnWord, crossword);
                    if (s.equals (sN))
                        listWords.add (makeWord (sN, j, i, j - lnWord + 1, i - lnWord + 1));
                    //--------------------------------------------------
                    sN = makeStringDownL (j, i, lnWord, crossword);
                    if (s.equals (sN))
                        listWords.add (makeWord (sN, j, i, j - lnWord + 1, i + lnWord - 1));
                    //--------------------------------------------------
                    sN = makeStringDownR (j, i, lnWord,  crossword);
                    if (s.equals (sN))
                        listWords.add (makeWord (sN, j, i, j + lnWord - 1, i + lnWord - 1));
                    //--------------------------------------------------
                    sN = makeStringUpR (j, i, lnWord, crossword);
                    if (s.equals (sN))
                        listWords.add (makeWord (sN, j, i, j + lnWord - 1, i - lnWord + 1));
                    //--------------------------------------------------

                }
            }
        }
        return listWords;
    }

    private static String makeStringUpL(int sX, int sY, int ln,  int[][] crossword)
    {
        // int        N         = crossword.length;// number of rows
        // int        M         = crossword[0].length;// number of columns
        if ((sX - ln + 1) < 0)
            return null;
        if ((sY - ln + 1) < 0)
            return null;
        String sN = "";
        for (int i = 0; i < ln; i++)
            sN = sN + String.valueOf ((char) crossword[sY - i][sX - i]);
        return sN;
    }

    private static String makeStringDownL(int sX, int sY, int ln, int[][] crossword)
    {
        int        N         = crossword.length;// number of rows
        // int        M         = crossword[0].length;// number of columns
        if ((sX - ln + 1) < 0)
            return null;
        if ((sY + ln) > N)
            return null;
        String sN = "";
        for (int i = 0; i < ln; i++)
            sN = sN + String.valueOf ((char) crossword[sY + i][sX - i]);
        return sN;
    }

    private static String makeStringDownR(int sX, int sY, int ln,  int[][] crossword)
    {
        int        N         = crossword.length;// number of rows
        int        M         = crossword[0].length;// number of columns
        if ((sX + ln) > M)
            return null;
        if ((sY + ln) > N)
            return null;
        String sN = "";
        for (int i = 0; i < ln; i++)
            sN = sN + String.valueOf ((char) crossword[sY + i][sX + i]);
        return sN;
    }

    private static String makeStringUpR(int sX, int sY, int ln,  int[][] crossword)
    {
        // int        N         = crossword.length;// number of rows
        int        M         = crossword[0].length;// number of columns
        if ((sX + ln) > M)
            return null;
        if ((sY - ln + 1) < 0)
            return null;
        String sN = "";
        for (int i = 0; i < ln; i++)
            sN = sN + String.valueOf ((char) crossword[sY - i][sX + i]);
        return sN;
    }

    private static String makeStringDown(int sX, int sY, int ln,  int[][] crossword)
    {
        int        N         = crossword.length;// number of rows
        //  int        M         = crossword[0].length;// number of columns
        if ((sY + ln) > N)
            return null;
        String sN = "";
        for (int i = sY; i < sY + ln; i++)
            sN = sN + String.valueOf ((char) crossword[i][sX]);
        return sN;
    }

    private static String makeStringUp(int sX, int sY, int ln, int[][] crossword)
    {
        //  int        N         = crossword.length;// number of rows
        //  int        M         = crossword[0].length;// number of columns
        if ((sY - ln + 1) < 0)
            return null;
        String sN = "";
        for (int i = sY; i >= sY - ln + 1; i--)
            sN = sN + String.valueOf ((char) crossword[i][sX]);
        return sN;
    }

    private static String makeStringL(int sX, int sY, int ln, int[][] crossword)
    {
        // int        N         = crossword.length;// number of rows
        // int        M         = crossword[0].length;// number of columns
        if ((sX - ln + 1) < 0)
            return null;
        String sN = "";
        for (int i = sX; i >= sX - ln + 1; i--)
            sN = sN + String.valueOf ((char) crossword[sY][i]);
        return sN;
    }

    private static String makeStringR(int sX, int sY, int ln,  int[][] crossword)
    {
        //  int        N         = crossword.length;// number of rows
        int        M         = crossword[0].length;// number of columns
        if ((sX + ln) > M)
            return null;
        String sN = "";
        for (int i = sX; i < sX + ln; i++)
            sN = sN + String.valueOf ((char) crossword[sY][i]);
        return sN;
    }

    private static Word makeWord(String s, int sX, int sY, int eX, int eY)
    {
        Word w = new Word (s);
        w.setStartPoint (sX, sY);
        w.setEndPoint (eX, eY);
        return w;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
