public class InterfaceImplementation {
    public static void main(String[] args) {
        Playable guitar = new Guitar();
        Playable piano = new Piano();
        guitar.play();
        piano.play();
    }
}

interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("Strum the guitar.");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("Play the piano.");
    }
}
