import java.util.Scanner;

public class Project2 {
    static HashDocument preamble;
    static HashDocument dream;
    static HashDocument gettysburg;

    public static void main(String[] args)
    {
        preamble = new HashDocument("Preamble", "We the People of the United States, in Order to form a more perfect Union, establish Justice, insure domestic Tranquility, provide for the common defense, promote the general Welfare, and secure the Blessings of Liberty to ourselves and our Posterity, do ordain and establish this Constitution for the United States of America.\n");
        gettysburg = new HashDocument("Gettysburg",
            "Four score and seven years ago our fathers brought forth, upon this continent, a new nation, conceived in liberty, and dedicated to the proposition that \"all men are created equal.\"\"\n" +
            "Now we are engaged in a great civil war, testing whether that nation, or any nation so conceived, and so dedicated, can long endure. We are met on a great battle field of that war. We have come to dedicate a portion of it, as a final resting place for those who died here, that the nation might live. This we may, in all propriety do. But, in a larger sense, we can not dedicate -- we can not consecrate -- we can not hallow, this ground -- The brave men, living and dead, who struggled here, have hallowed it, far above our poor power to add or detract. The world will little note, nor long remember what we say here; while it can never forget what they did here.\n" +
            "It is rather for us, the living, to stand here, we here be dedicated to the great task remaining before us -- that, from these honored dead we take increased devotion to that cause for which they here, gave the last full measure of devotion -- that we here highly resolve these dead shall not have died in vain; that the nation, shall have a new birth of freedom, and that government of the people by the people for the people, shall not perish from the earth.\n");
        dream = new HashDocument("MLK I have a Dream",
            "I am happy to join with you today in what will go down in history as the greatest demonstration for freedom in the history of our nation.\n" +
            "Five score years ago, a great American, in whose symbolic shadow we stand today, signed the Emancipation Proclamation. This momentous decree came as a great beacon light of hope to millions of Negro slaves who had been seared in the flames of withering injustice. It came as a joyous daybreak to end the long night of their captivity.\n" +
            "But one hundred years later, the Negro still is not free. One hundred years later, the life of the Negro is still sadly crippled by the manacles of segregation and the chains of discrimination. One hundred years later, the Negro lives on a lonely island of poverty in the midst of a vast ocean of material prosperity. One hundred years later, the Negro is still languished in the corners of American society and finds himself an exile in his own land. And so we've come here today to dramatize a shameful condition.\n");

        HashDocument[] collection = {preamble, dream, gettysburg};
        // searching for "nation"

        System.out.print("Enter a word to search in the collection of documents. Press control-D to terminate.");
        System.out.print("search> ");

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            searchTerm(collection, line);
            System.out.print("\nsearch> ");
        }
        sc.close();
        System.out.println("Bye");
    }

    public static void searchTerm(HashDocument[] docs, String search)
    {
        System.out.println("Searching for : "+ search);
        int numDocsWTerm = 0;
        double idf;
        for(HashDocument hd : docs)
            if (hd.contains(search))
                numDocsWTerm++;
        if (numDocsWTerm > 0)
            idf = 1.0 + Math.log(docs.length / (double)numDocsWTerm);
        else
            idf = 1.0;
        System.out.println("Num docs containing("+search+") = "+numDocsWTerm);
        System.out.println("IDF("+search+") = "+idf);

        for (int i = 0; i < docs.length; i++) {
            if (docs[i].termFrequency(search) > 0) {
                double d = docs[i].termFrequency(search) * idf;
                System.out.println("\nin ["+docs[i].getTitle()+"]");
                System.out.println("      TF = "+docs[i].termFrequency(search));
                System.out.println("  TF-IDF = "+d);
            }
        }

        double max = -1;
        int idx = -1;
        for (int i = 0; i < docs.length; i++) {
            double d = docs[i].termFrequency(search) * idf;
            if (d > 0 && d > max) {
                max = d;
                idx = i;
            }
        }
        if (idx == -1) {
            System.out.println("No document with the term ("+search+") found.");
        }
        else {
            System.out.println("\nMost relevant document for search ("+search+"):");
            System.out.println(docs[idx].getTitle());
            System.out.println("      TF = "+docs[idx].termFrequency(search));
            System.out.println("  TF-IDF = "+max);
        }
    }
}
