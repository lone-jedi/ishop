<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>All products</title>
</head>
<body>
<div class="container">
    <h1>Add new product</h1>
    <hr>
    <form action="/product/add" method="post">
        <#if error_message??>
            <div class="mb3">
                <div class="alert alert-danger" role="alert">
                    ${error_message}
                </div>
            </div>
        </#if>

        <div class="mb-3">
            <label for="exampleInputProduct1" class="form-label">Product name</label>
            <input type="text" class="form-control" id="exampleInputProduct1"
                   name="name" aria-describedby="productHelp"
                   value="${name!}" required>
            <div id="productHelp" class="form-text">Enter a product name</div>
        </div>

        <div class="mb-3">
            <label for="exampleInputPrice1" class="form-label">Product price</label>
            <input type="number" step="0.0001" class="form-control" id="exampleInputPrice1"
                   name="price" aria-describedby="priceHelp"
                   value="${price!}" required>
            <div id="priceHelp" class="form-text">Enter a product price</div>
        </div>

        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>

<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

</body>
</html>
