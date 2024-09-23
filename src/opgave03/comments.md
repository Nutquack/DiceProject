De to metoder `playerOne()` og `playerTwo()` ligner hinanden ret meget, er det muligt at slå den sammen til en metode?

---

Da I ved at faces har længe 2, kan I reducerer denne stump kode

        System.out.print("You rolled: ");
        for (int i = 0; i < faces.length; i++){
            System.out.print(faces[i]+ " ");
            if(i<1){
                System.out.print("and ");
            }
        }

til 

    System.out.println("You rolled: " + faces[0] + " and " + faces[1]");

---
