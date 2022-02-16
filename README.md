Ce programme se décompose en trois fichiers principaux : 
- le Main, comprenant la fonction main qui permet d'exécuter le programme et d'effectuer les deux opérations demandées.
- Le fichier PlanningParser qui possède une fonction permettant de lire le fichier d'entrée et d'en renvoyer ses lignes en tant que Liste de Coordonnées.
- Le fichier PlanningCalcul, comprenant toutes les opérations nécessaires à l'exécution du programme

Il y a également le Record Coordinates, qui contient les doubles latitude et longitude. L'utilisation d'un record au lieu d'une classe permet d'avoir les fonctions hashcode et equals autogénérées.
Et enfin, le Record Zone permet de regrouper toutes les coordonnées d'une zone en un seul objet. Il possède la fonction roundValue, 
qui permet d'arrondir les valeurs au 0.5 près, afin de faire correspondre les différents points en fonction des zones, 
ce qui sera utile pour le regroupement des points d'intérêt par zone (par exemple, des points avec pour coordonnées [-12.2, 5] et [-12.4, 5.2] 
auront une fois arrondi tous les deux pour valeur [12, 5], ce qui permettra de les regrouper).
Il possède également la fonction isInZone, qui retourne vrai si les coordonnées sont présentes dans la zone.

De manière générale, j'ai utilisé au maximum les streams dès qu'il fallait opérer sur une liste, car ils permettent d'effectuer plusieurs opérations pour chaque élément tout 
en gardant le code lisible.

Pour la question du nombre de points d'intérêt dans une zone, j'ai, à l'aide d'un stream, itéré sur chaque élément de la liste de coordonnées et filtré les éléments étant dans la zone (en utilisant
la fonction isInZone, qui permet de vérifier si les coordonnées sont présentes dans la zone donnée), puis retourné le total des entrées respectant cette condition.

Pour la question de la récupération des N plus grosses zones, la fonction que j'ai créé se décompose en deux streams
- Le premier convertit ma liste de coordonnées en une Map qui a pour clé une Zone, et pour valeur le nombre de points contenus dans celle-ci. 
Pour ce faire, les valeurs de ma coordonnée sont converties en zone avec la fonction Zone.of, qui prend les coordonnées, 
les arrondit aux valeurs minimales au 0.5 près et génère les coordonnées maximales en leur rajoutant 0.5.
- Le second trie la Map en fonction de la valeur par ordre décroissant et filtre pour ne garder que les N premiers éléments, puis extrait et retourne les clés (les Zones) en tant que liste de Zones.

Au niveau des tests, j'ai fait un fichier de test par classe. Le fichier PlanningCalculTest teste la bonne exécution et le renvoi des bonnes valeurs
des fonctions de calcul, le fichier PlanningParserTest vérifie que la fonction permettant de lire et de récupérer les données du fichier s'exécute correctement,
Et enfin le fichier ZoneTests vérifie que l'algorithme de vérification de la présence ou non dans une zone fonctionne bien.

