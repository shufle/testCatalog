<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Авторы</title>
</head>
<body>
Авторы:
<table>
    <#list authors as book>
    <p>  <a href="/listAuthors?p=${book.getAuthorName()}"> ${book.getAuthorName()} </a>
        </#list>
</table>
<a href="/">Домой</a>

<dialog>
    <p>Книги этого автора:</p>

    <#list booksFilteredByAuthor as book>
    <p> <a href="/listBooks?p=${book.getTitle()}">${book.getTitle()}</a> <p>
        </#list>

        <button id="close">Закрыть</button>
</dialog>

<script type = text/javascript>
    var dialog = document.querySelector('dialog');

    dialog.showModal();
    document.querySelector('#close').onclick = function() {
        dialog.close();
    };
</script>

</body>
</html>