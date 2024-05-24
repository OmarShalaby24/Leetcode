public class MaximumScoreWordsFormedbyLetters {
    public static void main(String[] args) {
        String[] words = new String[]{"dog" ,"cat", "dad","good"};
        char[] letters = new char[]{'a','a','c','d','d','d','g','o','o'};
        int[] score = new int[]{1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        System.out.println(maxScoreWords(words, letters, score));

    }
    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterCount = new int[26];
        for (char l : letters) {
            letterCount[l - 'a']++;
        }
        return dfs(words, score, letterCount, 0);
    }
    
    public static int dfs(String[] words, int[] score, int[] letterCount, int index){
        if(index == words.length) return 0;
        //skip current word and go for the next one
        int skipScore = dfs(words, score, letterCount, index+1);
        int wordScore = 0;
        int[] newLetterCount = letterCount.clone();
        boolean valid = true;
        for(char c : words[index].toCharArray()){
            if(newLetterCount[c-'a'] == 0) {
                valid = false;
                break;
            }
            newLetterCount[c-'a']--;
            wordScore+=score[c-'a'];
        }
        int takeScore = 0;
        if(valid){
            takeScore = wordScore + dfs(words, score, newLetterCount, index+1);
        }
        return Math.max(takeScore, skipScore);
    }
}
