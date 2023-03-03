//Как известно, в США президент выбирается не прямым голосованием,
// а путем двухуровневого голосования.
//Сначала проводятся выборы в каждом штате и определяется победитель выборов в данном штате.
// Затем проводятся государственные выборы: на этих выборах каждый штат имеет определенное
// число голосов — число выборщиков от этого штата.
//На практике, все выборщики от штата голосуют в соответствии с результами голосования внутри штата,
// то есть на заключительной стадии выборов в голосовании участвуют штаты,
// имеющие различное число голосов.
//Входной файл: in.txt
//В первой строке дано количество записей. Далее, каждая запись содержит фамилию кандидата и
// число голосов, отданных за него в одном из штатов. Подведите итоги выборов: для каждого из
// участника голосования определите число отданных за него голосов.
//Пример ввода:
//5
//McCain 10
//McCain 5
//Obama 9
//Obama 8
//McCain 1
//Пример вывода:
//McCain 16
//Obama 17

//Github - отдельный репозиторий на весь урок (можно и на отдельную задачу)
//Коммиты:
//условие в комментарии и никакого кода
//решение без учёта файлов - чтение с клавиатуры и вывод на экран
//добавляем файлы: in.txt для ввода и out.txt для вывода
//разбиваем задачу на методы
//try..catch


import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Task01 {
  final public static String SEP = " ";

  public static void main(String[] args) throws IOException {
    File inputFilePath = new File("res/in.txt");
    File outputFilePath = new File("res/out.txt");
//    Map<String, Integer> presidentsVoices = new HashMap<>();
    writeToFile(readFromFile(inputFilePath), outputFilePath);
  }
  public static Map<String, Integer> readFromFile(File filename) throws IOException {
    Map<String, Integer> presidentsVoices = new HashMap<>();
    try {
      BufferedReader inputFileReader = new BufferedReader(new FileReader(filename));
      int number = Integer.parseInt(inputFileReader.readLine());
      for (int i = 0; i < number; ++i) {
        String row = inputFileReader.readLine();
        int sepPoz = row.indexOf(SEP);
        String name = row.substring(0, sepPoz);
        int voice = Integer.parseInt(row.substring(sepPoz + 1));
        if (presidentsVoices.containsKey(name)) {
          voice += presidentsVoices.get(name);
        }
        presidentsVoices.put(name, voice);
      }
      inputFileReader.close();
    } catch (NumberFormatException e) {
      System.out.println("Wrong number format" + e.getMessage());
    } catch (FileNotFoundException e) {
      System.out.println("File not found" + e.getMessage());
    } catch (EOFException e) {
      System.out.println("Unexpected end of file");
    }
    return presidentsVoices;
  }
  public static void writeToFile (Map<String, Integer> presidentsVoices,
                                  File filename) throws IOException {
    FileWriter fileWriter = new FileWriter(filename);
    for (String president : presidentsVoices.keySet()) {
      int voices = presidentsVoices.get(president);
      fileWriter.write(president + " " + voices + "\n");
    }
    fileWriter.close();
  }
}