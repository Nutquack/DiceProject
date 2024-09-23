I ved at der rulles to terninger, så er

            for (int i = 0; i < faces.length; i++){
                System.out.print(faces[i]+ " ");
                if(i<1){
                    System.out.print("and ");
                }
            }

måske lige kompliceret nok, når det kan erstates med

    System.out.println(faces[0]+ " and "+ faces[1]);

Ellers rigtig god løsning.