<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Книги</title>
</head>
<body>

Книги:
<table>
<#list books as book>
    <p>  <a href="/listBooks?p=${book.getTitle()}"> ${book.getTitle()} </a>
</#list>
</table>
<a href="/">Домой</a>

<dialog>
    <p>Автор/ы книг/и c этим названием:</p>

        <#list booksFilteredByTitle as book>
          <p> <a href="/listAuthors?p=${book.getAuthorName()}">${book.getAuthorName()}</a> <p>
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