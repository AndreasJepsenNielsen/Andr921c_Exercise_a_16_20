public class Kap16Opgave20 {

    public static void main(String[] args) {
        LinkedIntList A = new LinkedIntList();

        A.add(10);
        A.add(31);
        A.add(42);
        A.add(23);
        A.add(44);
        A.add(75);
        A.add(86);


    shift(A);
    }

    // Synes absolut det her var den sværeste af alle opgaverne i kapitel 16, tog mig noget tid at finde ud af hvordan man kunne gøre det her online, // link til hjælp : https://stackoverflow.com/questions/19909337/rearranging-a-linked-list
    // Synes heller ikke det har været så nødvendigt at bruge nodes i nogen af de andre opgaver bortset fra den her.
    public static void shift(LinkedIntList list) {

        ListNode even = null; // lige index plads
        ListNode evenEnd = null; // den sidste lige index plads
        ListNode odd = null; // ulige index plads
        ListNode oddEnd = null; // sidste ulige index plads

        ListNode currentIndex = list.front;
        int i = 0;
        while(currentIndex != null) // så længe der er en ny værdi i listen køre loopet
        {
            if(i % 2 == 0 ) // hvis i er lige
            {
                if( even == null) // hvis even ikke har nogen værdi sættes den til currentIndex.
                {
                    even = currentIndex;
                    evenEnd = currentIndex;
                }else{ // hvis Even har en værdi, bliver den nye værdi tilføjet ved evenEnd.next, altså bagerst i listen.
                    evenEnd.next = currentIndex;
                    evenEnd = currentIndex;
                }

                currentIndex = currentIndex.next; // går videre i listen
                evenEnd.next = null; // sætter den sidste index til 0
            }else{ // hvis i er ulige
                if(odd == null) // hvis odd ingen værdi har
                {
                    odd = currentIndex; // odd får værdien af current index
                    oddEnd = currentIndex;
                }else{ // hvis odd har en værdi
                    oddEnd.next = currentIndex; // hvis odd har en værdi, bliver den ligesom i even tilføjet ved slutningen af odd altså oddEnd.
                    oddEnd = currentIndex;
                }
                currentIndex = currentIndex.next; // itererer videre i loopet
                oddEnd.next = null;
            }
            i++; // i får tilføjet +1
        }
        list.front = even; // sætter alle værdierne i even til at være de første værdier i listen til at være even.
        evenEnd.next = odd; // Tilføjer alle odd værdierne til slutningen af listen, derfor bliver alle even værdierne først
        System.out.println(list); // udskriver listen
    }

}
