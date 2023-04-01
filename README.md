# server-eetach-hackatone
<h1>Недосервер</h1>
<hr>
<h3>Что по эндпоинтам?</h3>
<ul>
  <li><tt>/auth</tt> - post - принимает класс пользователя. Если пользователь существуетб возвращает <tt>ResponseEntity</tt> с <tt>ok</tt> кодом, а также полную информацию о ползователе, которая есть на сервере
  В случае неудачной авторизации, возвращает <tt>BAD REQUEST</tt></li>
  <li><tt>/get-users</tt> - get - возвращает всех пользователей, которые есть на сервере (нужно дял лидерборда). Если в запросе указать параметр по типу: <tt>?profession=Профессия 1</tt>, то вернет всех пользователей, с данной профессией(должностью)</li>
  <li><tt>/get-test/{id}</tt> - get - всего пока есть два теста: 1 и 2. по данным запросам возвращает вопросы из этих тестов</li>
  <li><tt>/upload-result</tt> - post - по идее, должен созранять результаты пройденного теста. Принимает в себя <tt>List<Result></tt> и ничего не возвращает (не уверен, что оно работает)</li>
</ul>
<h3>А что за классы?</h3>
<h4>Все классы лежат в <tt>java/thecodingclowns/onboarding/server/Models</tt>. Там вроде понятно, что есть в классе. Для авторизации нужен класс <tt>User</tt> с непустыми только двумя полями: почты и пароля.
Для <tt>/upload-result</tt> нужен список из классов <tt>Result</tt>. По задумке, его можно получить из класса Test, но пока пишу - уже не уверен. </h4> <img src="https://user-images.githubusercontent.com/80172256/229303228-c99b4cf2-3577-482a-b912-1428985cb337.jpg" style="height:300px">xd</img>

<h3>А как пользоваться?</h3>
<h4>Шаг 1:</h4>
<img src="https://user-images.githubusercontent.com/80172256/229303447-108810e0-b521-4732-9d66-520686de8897.jpg"/>
<h4>Шаг 2:</h4>
<h5>Скачиваем postgreSql: https://www.enterprisedb.com/postgresql-tutorial-resources-training?uuid=4726a163-a071-4af4-8395-6d239c34d4a1&campaignId=7012J000001h3GiQAI</h5>
<h4>Шаг 3:</h4>
<h5>Скачиваем minIO(сама верхня кнопка скачать, где сервер): https://min.io/download#/windows </h5>
<h4>Шаг 4:</h4>
<h5>Создаем в postgreSql бд с именем <tt>onboarding</tt> </h5>
<h4>Шаг 4.5:</h4>
<h5>Добавить путь до папки, в которой лежит minIO в <tt>PATH</tt> (https://remontka.pro/add-to-path-variable-windows/) </h5>
<h4>Шаг 5:</h4>
<h5>Поменять имя пользователя и пароль от postgreSql в <tt>src\main\java\thecodingclowns\onboarding\server\resources\application.properties</tt> (spring.datasource.username=СВОЙ_ПОЛЬЗОВАТЕЛЬ
spring.datasource.password=СВОЙ_ПАРОЛЬ) </h5>
<h4>Шаг 6:</h4>
<h5>Открываем проект, прописываем <tt>minio server "полный_путь_до_папки_где_будет_сервер_без_кавычек" --console-address ":9001"</tt></h5>
<h4>Шаг 7:</h4>
<h5>В другом терминале пишем <tt>.\mvnw< spring-boot:run/tt></h5>
<h4>Шаг 8(опционально):</h4>
<h5>Повторять <tt>Шаг 1</tt> пока не заработает</h5>
