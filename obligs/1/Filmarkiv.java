public class Filmarkiv implements FilmarkivADT{

    private Film[] filmer;
    private int antall;

    public Filmarkiv(){
        filmer = new Film[100];
        antall = 0;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        Film[] nyfilmer = new Film[antall-1];
        boolean fanntnr = false;
        for(int i = 0, j = 0; i<antall; i++){
            if(filmer[i].getFilmnr() != filmnr){
                nyfilmer[j++] = filmer[i];
            } else {
                fanntnr = true;
            }
        }

        if(fanntnr) filmer = nyfilmer;
        return fanntnr;
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int count = 0;
        for(int i = 0;i<antall;i++){
            if(filmer[i].getSjanger() == sjanger) count++;
        }
        return count;
    }

    @Override
    public void visFilm(int nr) {
        for(int i = 0;i<antall;i++){
            if(filmer[i].getFilmnr() == nr){
                System.out.print(filmer[i].toString());
            }
        }
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] delfilmer = new Film[antall];
        int size = 0;
        for(int i = 0;i<antall;i++){
            String tittel = filmer[i].getTittel();
            if(tittel.contains(delstreng)){
                delfilmer[size++] = filmer[i];
            }
        }
        trimtabell(delfilmer, size);
        return delfilmer;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if(antall > filmer.length) utvidtabell(filmer);
        filmer[antall] = nyFilm;
    }

    private void utvidtabell(Film[] tabell){
        Film[] nytabell = new Film[tabell.length*2];
        for(int i=0;i<tabell.length;i++){
            nytabell[i] = tabell[i];
        }
        tabell = nytabell;
    }

    private void trimtabell(Film[] tabell, int size){
        Film[] nytabell = new Film[size];
        for(int i=0;i<tabell.length;i++){
            nytabell[i] = tabell[i];
        }
        tabell = nytabell;
    }
}