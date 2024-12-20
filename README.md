# Mise en place d'un ORM

Compétences abordées :
- implémentation d'entités
- configuration d'un projet Spring pour la communication avec une BDD PostgreSQL

Marche à suivre : vous trouverez un énoncé dans le sous-dossier "todo" de ce dépôt


# Ajout du package de sécurité de connexion

Fichier log4j.properties :
Le fichier `log4j.properties` que vous avez dans le dossier `resources` configure **Log4j**, un framework de logging populaire utilisé en Java. Ce fichier déclare la façon dont les logs doivent être générés, où ils doivent être envoyés (console, fichiers, etc.), et quels niveaux de log doivent être activés pour différentes parties de l'application. Voici une explication détaillée de chaque ligne de votre fichier de configuration :

### 1. **Configuration de base du logger root :**

```properties
log4j.rootLogger = WARN, stdout
```

- **`log4j.rootLogger`** : C'est le **logger racine** (root logger) dans Log4j. Il est utilisé comme logger par défaut pour toutes les classes de l'application qui n'ont pas de logger spécifique configuré.
- **`WARN`** : C'est le niveau de logging pour le logger racine. Ici, seuls les logs avec un niveau `WARN`, `ERROR`, ou `FATAL` seront capturés. Les logs de niveau inférieur comme `INFO` ou `DEBUG` seront ignorés. Ce niveau est souvent utilisé pour ne capter que les événements importants ou les erreurs.
- **`stdout`** : Cela définit le **`appender`** (destination de sortie des logs) pour le logger racine. Ici, les logs sont envoyés à la console (stdout), ce qui signifie qu'ils seront affichés dans le terminal ou la fenêtre de log de l'application.

### 2. **Configuration de l'appender `stdout` :**

```properties
log4j.appender.stdout = org.apache.log4j.ConsoleAppender
```

- **`log4j.appender.stdout`** : Cette ligne définit un **appender** nommé `stdout`. Un appender est responsable de la sortie des logs.
- **`org.apache.log4j.ConsoleAppender`** : Cela spécifie que l'appender est une instance de `ConsoleAppender`, ce qui signifie que les logs seront envoyés vers la **console** (généralement affichés dans le terminal ou la console d'exécution de l'application).

### 3. **Définition du format des logs :**

```properties
log4j.appender.stdout.layout = org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern = %d %5p [%c{1}] (%F:%L) - %m%n
```

- **`log4j.appender.stdout.layout`** : Cette ligne définit le type de mise en forme des logs pour cet appender. Ici, `PatternLayout` est utilisé, ce qui permet de définir un modèle personnalisé pour le format des messages de log.
- **`log4j.appender.stdout.layout.ConversionPattern`** : Ceci définit précisément le modèle utilisé pour formater chaque log. Le modèle spécifie quel type d'information doit être inclus dans chaque ligne de log. Dans ce cas, il est défini par :

    - **`%d`** : Date et heure de l'événement de log.
    - **`%5p`** : Le niveau de priorité du log (par exemple, `DEBUG`, `INFO`, `WARN`, etc.).
    - **`[%c{1}]`** : Le nom de la classe d'où provient le log, mais limité à une seule partie du nom de la classe (par exemple, si la classe est `com.example.MyClass`, alors seul `MyClass` sera affiché).
    - **`(%F:%L)`** : Le nom du fichier source et le numéro de la ligne où le log a été généré.
    - **`- %m`** : Le message du log lui-même.
    - **`%n`** : Un saut de ligne, pour que chaque message de log apparaisse sur une nouvelle ligne.

Cela donne un format de log qui ressemble à ceci :
```
2024-12-20 12:34:56 WARN [MyClass] (MyClass.java:42) - Something went wrong!
```

### 4. **Configuration des loggers spécifiques à Thymeleaf :**

```properties
log4j.logger.org.thymeleaf = DEBUG
log4j.logger.org.thymeleaf.TemplateEngine.CONFIG = DEBUG
log4j.logger.org.thymeleaf.TemplateEngine.TIMER = DEBUG
log4j.logger.org.thymeleaf.TemplateEngine.PARSERCACHE = DEBUG
```

- **`log4j.logger.org.thymeleaf = DEBUG`** : Cela configure le niveau de log pour la bibliothèque **Thymeleaf** (le moteur de template utilisé dans votre application) à **DEBUG**, ce qui signifie que tous les logs de Thymeleaf au niveau `DEBUG` et au-dessus (c'est-à-dire `INFO`, `WARN`, `ERROR`, etc.) seront capturés. Cela est utile pour déboguer et obtenir plus de détails sur l'exécution de Thymeleaf.

- **`log4j.logger.org.thymeleaf.TemplateEngine.CONFIG = DEBUG`** : Cette ligne configure le niveau de log pour le sous-package `TemplateEngine.CONFIG` de Thymeleaf, spécifiquement pour les logs liés à la configuration de Thymeleaf. Le niveau `DEBUG` ici permet de suivre des détails fins sur la configuration du moteur de template.

- **`log4j.logger.org.thymeleaf.TemplateEngine.TIMER = DEBUG`** : Active les logs à des fins de **timing** (mesure des temps d'exécution) pour les templates Thymeleaf. Cela peut être utile pour surveiller les performances de votre application, notamment le temps nécessaire pour générer les pages.

- **`log4j.logger.org.thymeleaf.TemplateEngine.PARSERCACHE = DEBUG`** : Cette ligne active le logging pour les événements relatifs au **cache des parseurs** dans Thymeleaf. Cela pourrait être utile si vous souhaitez voir des informations sur la manière dont les templates sont mis en cache et réutilisés, ce qui peut améliorer les performances dans certains cas.

### En résumé :

- Ce fichier **`log4j.properties`** configure **Log4j** pour enregistrer les messages de log à différents niveaux, avec une priorité `WARN` pour la racine, mais des logs plus détaillés (au niveau `DEBUG`) pour certaines parties spécifiques de l'application comme **Thymeleaf**.
- Les logs seront envoyés à la **console**, et leur format est détaillé pour inclure des informations comme la date, le niveau de log, la classe d'où provient le log, et la ligne du fichier source.
- Si vous avez des problèmes avec Thymeleaf ou si vous souhaitez surveiller l'exécution de vos templates, les loggers définis pour Thymeleaf à `DEBUG` vous fourniront des informations détaillées.

Cette configuration vous permettra de mieux comprendre ce qui se passe dans votre application, notamment pendant le rendu des templates Thymeleaf et pour les autres parties critiques de l'application.