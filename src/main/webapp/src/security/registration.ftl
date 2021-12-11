<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Font Awesome -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
            rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
            href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
            rel="stylesheet"
    />
    <!-- MDB -->
    <link
            href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.css"
            rel="stylesheet"
    />
    <title>Registration</title>
</head>
<body>

<#-- TODO Move into style.css file. <style> BAD PRACTICE -->
<style>
    .back {
        background: #e2e2e2;
        width: 100%;
        position: absolute;
        top: 0;
        bottom: 0;
    }

    .div-center {
        width: 400px;
        height: 400px;
        background-color: #fff;
        position: absolute;
        left: 0;
        right: 0;
        top: 0;
        bottom: 0;
        margin: auto;
        max-width: 100%;
        max-height: 100%;
        overflow: auto;
        padding: 1em 2em;
        border-bottom: 2px solid #ccc;
        display: table;
    }

    div.content {
        display: table-cell;
        vertical-align: middle;
    }
</style>

<main>
    <div class="back">
        <div class="div-center">
            <div class="content">
                <#if error_msg??>
                    <div>
                        <p class="alert-warning">${error_msg}</p>
                    </div>
                </#if>
                <h3>Welcome new user</h3>
                <hr/>
                <form action="/registration" method="post">
                    <div class="mt-2 form-outline">
                        <input type="email" id="typeEmail" class="form-control"
                               value="${email!}" name="email" required/>
                        <label class="form-label" for="typeEmail">Email input</label>
                    </div>
                    <div class="mt-2 form-outline">
                        <input type="password" id="typePassword" class="form-control" name="password" required/>
                        <label class="form-label" for="typePassword">Password input</label>
                    </div>
                    <div class="row">
                        <div class="col-6">
                            <button type="submit" class="mt-4 btn btn-primary">Register</button>
                        </div>
                        <div class="col-6">
                            <a class="mt-4 btn btn-light" href="/">Back to home</a>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>

</main>


<!-- MDB -->
<script
        type="text/javascript"
        src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/3.10.1/mdb.min.js"
></script>

</body>
</html>