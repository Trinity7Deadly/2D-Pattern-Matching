package pattern;
//Kaelan, Graehm, Fionn, Julian

public class FingerprintMatcher implements Matcher{
    @Override
    public int[] match(int[][] pattern, int[][] text) {
        int pL=pattern.length;
        int tL=text.length;
        int pF=hashRegion(pattern, 0, 0, pL); //pattern fingerprint
        for(int row=0; row<=tL-pL; row++) {
            int fp=hashRegion(text, row, 0, pL); //fingerprint
            if(fp== pF && matchRegion(pattern, text, row, 0)) {return new int[]{row, 0};}
            for(int col=1; col<=tL-pL; col++){
                int lfp=hashColumn(text, row, col-1, pL); //left fingerprint
                fp^=lfp;
                int rfp=hashColumn(text, row, (col+pL)-1, pL); //right fingerprint
                fp^=rfp;
                if(fp== pF && matchRegion(pattern, text, row, col)) {return new int[]{row,col};}
            }
        }
        return null;
    }

    public int hashRegion(int[][] text, int startRow, int startCol, int size){
        int fp=0;
        for(int i=startRow; i<startRow+size; i++){
            for(int j=startCol; j<startCol+size; j++){fp^=text[i][j];}
        }
        return fp;
    }

    public int hashColumn(int[][] text, int row, int column, int length){
        int fp=0;
        for(int i=row; i<=(row+length)-1; i++) {fp^=text[i][column];}
        return fp;
    }

    private boolean matchRegion(int[][] pattern, int[][] text, int i, int j) {
        int pL=pattern.length;
        for (int x=0; x<pL; x++) {
            for (int y=0; y<pL; y++) {
                if (pattern[x][y]!=text[i+x][j+y]) {return false;}
            }
        }
        return true;
    }
}

