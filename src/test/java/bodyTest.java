import org.junit.Test;
import static org.junit.Assert.*;

public class bodyTest {

    @Test
    public void boundaries() {
        int[] sizetests = {-100, 0, 1, 3,100,150 };
        int[] rejectedforcetests = {-200,-150,0,0,150,200};

        boolean x = true;
        body b = new body();
        int total;

        for(int i = 0 ; i < sizetests.length ; i++){

            // check if arrays can be created
            if(sizetests[i]>0) {

                int[] rejectedF = new int[sizetests[i]]; //rejected magnitudes

                // if there are a lot of forces more than test cases put the rest = 0
                if (sizetests[i] < rejectedforcetests.length) {
                    for (int j = 0; j < rejectedF.length; j++) {
                        rejectedF[j] = rejectedforcetests[j];
                    }

                } else {
                    for (int j = 0; j < rejectedforcetests.length; j++) {
                        rejectedF[j] = rejectedforcetests[j];
                    }

                    //put other element = 0
                    for (int k = sizetests[i]; k < rejectedF.length; k++)
                        rejectedF[k] = 0;
                }

                //check if magnitude of forces out of boundaries
                if (b.idle(rejectedF, sizetests[i]) == true) {
                    x = false;
                    break;
                }

            }
            else {

                int[] emptyArr = new int[10];

                //check if number of forces out of boundaries
                if ((sizetests[i] < 0 || sizetests[i] > 100) && (b.idle(emptyArr, sizetests[i]) == true)) {
                    x = false;
                    break;
                }

            }
        }
        assertTrue(x);
    }

    @Test
    public void result(){
        int[] sizetests = { 1, 3,100 };
        int[] forces = {-100,-50,0,0,50,100};
        boolean x = true;
        body b = new body();
        int total;

        for(int i = 0 ; i < sizetests.length ; i++) {

            int[] testForce = new int[sizetests[i]]; //accepted magnitudes

            if (sizetests[i] < forces.length) {
                for (int j = 0; j < testForce.length; j++) {
                    testForce[j] = forces[j];
                }

            } else {
                for (int j = 0; j < forces.length; j++) {
                    testForce[j] = forces[j];
                }

                //put other element = 0
                for (int k = sizetests[i]; k < testForce.length; k++)
                    testForce[k] = 0;
            }
            //calculate total for idle body
            total = 0;

            for (int m = 0; m < sizetests[i]; m++) {
                total += testForce[m];
            }
            //check if answer is right
            if (b.idle(testForce, sizetests[i]) == true && total != 0) {
                x = false;
                break;
            }
        }
        assertTrue(x);

    }
}
