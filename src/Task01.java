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


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Task01 {
  final public static String SEP = " ";
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<String, Integer> presidentsVoices = new HashMap<>();
    int number = Integer.parseInt(br.readLine());
    for (int i = 0; i < number; ++i) {
      String presidentVoice = br.readLine();
      int sepPoz = presidentVoice.indexOf(SEP);
      String namePresident = presidentVoice.substring(0, sepPoz);
      int voices = Integer.parseInt(presidentVoice.substring(sepPoz + 1));
      if (presidentsVoices.containsKey(namePresident)) {
        voices += presidentsVoices.get(namePresident);
      }
      presidentsVoices.put(namePresident, voices);
    }
    for (String president: presidentsVoices.keySet()) {
      int voices = presidentsVoices.get(president);
      System.out.println(president + " " + voices);
    }
  }
}