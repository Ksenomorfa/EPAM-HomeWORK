package module4.t4;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Задание 4. Сериализация
 * Дана коллекция фильмов, содержащая информацию об актерах, снимавшихся в главных ролях
 * (один актер мог сниматься и в нескольких фильмах). Необходимо написать приложение, позволяющее
 * при запуске восстанавливать коллекцию фильмов, позволять ее модифицировать, а по завершении работы
 * приложения – сохранять (в файл). Для восстановления/сохранения коллекции использовать
 * cериализацию/десериализацию.
 */
public class CollectionOfFilms implements Serializable {
    private TreeMap<String, Set<String>> mapOfFilms = new TreeMap<>();

    public CollectionOfFilms() {
    }

    public CollectionOfFilms(TreeMap<String, Set<String>> mapOfFilms) {
        this.mapOfFilms = mapOfFilms;
    }

    void addFilm(String film, Set<String> actors) {
        mapOfFilms.put(film, actors);
    }

    void deleteFilm(String film) {
        mapOfFilms.remove(film);
    }

    void changeAllActorsInFilm(String film, Set<String> actors) {
        mapOfFilms.replace(film, actors);
    }

    void changeOneActorInFilm(String film, String oldActor, String newActor) {
        Set<String> setOfActors = mapOfFilms.get(film);
        setOfActors.remove(oldActor);
        setOfActors.add(newActor);
        mapOfFilms.replace(film, setOfActors);
    }

    void deleteActorFromFilm(String film, String actor) {
        Set<String> setOfActors = mapOfFilms.get(film);
        setOfActors.remove(actor);
        mapOfFilms.replace(film, setOfActors);
    }

    void addActorToFilm(String film, String actor) {
        Set<String> setOfActors = mapOfFilms.get(film);
        setOfActors.add(actor);
        mapOfFilms.replace(film, setOfActors);
    }

    @Override
    public String toString() {
        StringBuilder printedCollection = new StringBuilder();
        for (Map.Entry<String, Set<String>> e : mapOfFilms.entrySet()) {
            printedCollection.append(e.getKey()).append(" ").append(e.getValue()).append("\n");
        }
        return printedCollection.toString();
    }

}
