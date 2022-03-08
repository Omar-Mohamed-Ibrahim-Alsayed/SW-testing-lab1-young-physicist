import org.junit.Test;
import static org.junit.Assert.*;

public class bodyTest {

    @Test
    public void idle() {
        int[] sizetests = {-100, 0, 1, 3,100,150 };
        int[] rejectedforcetests = {-200,-150,0,0,150,200};
        int[] idleForces = {-100,-50,0,0,50,100};
        int[] notIdletests = {-100,-50,0,1,40,50};

        boolean x = true;
        body b = new body();
        int total;

        for(int i = 0 ; i < sizetests.length ; i++){

            // check if arrays can be created
            if(sizetests[i]>0) {

                int[] rejectedF = new int[sizetests[i]]; //rejected magnitudes
                int[] idleF = new int[sizetests[i]]; //accepted magnitudes
                int[] noIdleF = new int[sizetests[i]];     // accepted but not idle

                // if there are a lot of forces more than test cases put the rest = 0
                if (sizetests[i] < rejectedforcetests.length) {
                    for (int j = 0; j < rejectedF.length; j++) {
                        rejectedF[j] = rejectedforcetests[j];
                    }
                    for (int j = 0; j < rejectedF.length; j++) {
                        idleF[j] = idleForces[j];
                    }
                    for (int j = 0; j < rejectedF.length; j++) {
                        noIdleF[j] = notIdletests[j];
                    }
                } else {
                    for (int j = 0; j < rejectedforcetests.length; j++) {
                        rejectedF[j] = rejectedforcetests[j];
                    }
                    for (int j = 0; j < rejectedforcetests.length; j++) {
                        idleF[j] = idleForces[j];
                    }
                    for (int j = 0; j < rejectedforcetests.length; j++) {
                        noIdleF[j] = notIdletests[j];
                    }
                    //put other element = 0
                    for (int k = sizetests[i]; k < rejectedF.length; k++)
                        rejectedF[k] = 0;
                    for (int k = sizetests[i]; k < idleF.length; k++)
                        idleF[k] = 0;
                    for (int k = sizetests[i]; k < idleF.length; k++)
                        noIdleF[k] = 0;
                }

                //calculate total for idle body
                total = 0;

                for (int m = 0; m < sizetests[i]; m++) {
                    total += idleF[m];
                }

                //check if magnitude of forces out of boundaries
                if (b.idle(rejectedF, sizetests[i]) == true) {
                    x = false;
                    break;
                }
                //check if answer is right
                else if (b.idle(idleF, sizetests[i]) == true && total != 0) {
                    x = false;
                    break;
                }

                //calculate total for not idle body
                total = 0;

                for (int m = 0; m < sizetests[i]; m++) {
                    total += idleF[m];
                }
                //check if answer is right
                if (b.idle(noIdleF, sizetests[i]) == true && total != 0) {
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

}