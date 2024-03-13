<h1>Pendu</h1>

<h2> Réalisation </h2>
<ul>
    <li> Lecture aléatoire d'un mot à deviner à partir d'un fichier texte donné à la racine du projet. </li>
    <li> Affichage graphique de l'interface du jeu à l'aide de Swing. </li>
    <li> Affichage graphique du pendu qui évolue en fonction des erreurs du joueur.</li>
    <li> Affichage graphique des lettres déjà proposées par le joueur.</li>
    <li> Affichage (ou non) de la définition (niveau de difficulté).</li>
    <li> Utilisation (ou non) d'un timer (niveau de difficulté).</li>
    <li> Gestion des entrées utilisateur pour proposer des lettres.</li>
    <li> Vérification de la validité des entrées utilisateur (lettre de l'alphabet uniquement).</li>
    <li> Gestion du décompte des tentatives restantes.</li>
    <li> Gestion de la victoire ou de la défaite du joueur.</li>
    <li> Possibilité de rejouer une partie après la fin d'une partie.</li>
    <li> Page d'accueil pour séléctionner le dificulté</li>
    <li> Retourner à la page d'accueil a tout moment pendant le jeu</li>
</ul>
<h2> Point Architecture interessant  </h2>

<h3>Fabrique de Gestionnaire de mot</h3>
 J'ai créer une fabrique de gestionnaire de mot pour pouvoir changer de gestionnaire de mot facilement.
 A noter que celle-ci pourra évoluer vers un pattern Stratégie si on souhaite ajouter par exemple une selection de fichier.
<h3>Singleton Interface Main</h3>
J'ai utilisé un singleton pour l'interface Main pour pouvoir la rappeler sans devoir en recréer un quand je souhaite réaccéder à l'interface principale.
<h3> Launcher </h3>
J'ai utilisé un launcher pour lancer l'application. Cela permet de ne pas avoir de code dans le main et de pouvoir lancer l'application avec un seul appel de méthode.
Aussi de pouvoir facilement changer pour un autre type de lancement.
<h2> test </h2>
<ul>
    <li> test de la classe GestionnaireMot </li>
    <li> test de la classe Mot </li>
</ul>

<h2> Critique </h2>
Je pense que ma façon de faire : 
réaliser le projet le plus vite possible pour pouvoir ensuite le refactorer et le rendre plus propre.
à été une mauvaise idée car j'ai du faire des compromis pour pouvoir finir le projet à temps.
Je pense que j'aurais du prendre plus de temps pour réfléchir à l'architecture du projet et à la façon de le réaliser.
Ainsi j'aurais pas des fort couplage

