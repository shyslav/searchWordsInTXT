package searchwordsintxt;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

/**
 *
 * @author Shyshkin Vladyslav
 */
public class SearchWordsInTXT {

    public static void main(String[] args) throws IOException {
        file_save fs = new file_save();
        fs.create();
    }
}
/**
 *
 * @param array лист который хранит входящие данные
 * @param ansert лист ответов
 * @param splits массив который содержит разделенные слова
 * @param map карта для отсеивания слов буквы которых повторяются
 */
class file_save {

    public static void create() throws IOException {
        Scanner scan = new Scanner(Paths.get("input.txt"));
        ArrayList<String> array = new ArrayList<String>();
        ArrayList<String> ansert = new ArrayList<String>();
        int z = 0;
        //Считать файл и внести его в лист
        while (scan.hasNext()) {
            array.add(scan.next());
        }
        String[] splits = null;
        for (int l = 0; l < array.size(); l++) {
            //разделить если пристудствует символ [;,+,-,),(,?, ,_] и длина меньше 30 символов
            if (array.get(l).split("[;,+,-,),(,?, ,_]").length <= 30) {
                splits = array.get(l).split("[;,+,-,),(,?, ,_]");
            }
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            //проходим по всем элементам массива слов для того что-бы отсеят слова с повторяющимися буквами
            for (int i = 0; i < splits.length; i++) {
                //проходим по всем буквам слова
                for (int j = 0; j < splits[i].length(); j++) {
                    //если в карте уже существует такой ключь
                    if (map.containsKey(splits[i].charAt(j))) {
                        //занулить элемент массива
                        splits[i] = null;
                        //прекратить цикл
                        break;
                    } else {
                        //добавить эту букву в карту
                        map.put(splits[i].charAt(j), 1);
                    }
                }
                map.clear();
            }
            //добавить все не нулевые елементы в лист ответов
            for (String vv : splits) {
                if (vv != null) {
                    ansert.add(vv);
                }
            }
        }
        for (int i = 0; i < ansert.size(); i++) {
            System.out.println(ansert.get(i));
        }
    }
}
