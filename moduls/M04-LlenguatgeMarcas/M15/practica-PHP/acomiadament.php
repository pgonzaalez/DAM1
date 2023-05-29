<?php
echo "<link rel=stylesheet href=CSS/acomiadament.css>";
session_start();
caducarSessio();

if (isset($_SESSION['usuari'])) {
    $usuari = $_SESSION['usuari'];
    session_unset();
    session_destroy();
} else {
    header("Location: index.php");
}
function caducarSessio() {
    $inactivitat = 300; 
    if(isset($_SESSION['temps']) && (time() - $_SESSION['temps']) > $inactivitat) {
      session_unset();
      session_destroy();
      header('Location: inici.php?caducada=true');
      exit();
    }
    $_SESSION['temps'] = time();
  }
?>


<!DOCTYPE html>
<html lang="ca">

<head>
    <meta charset="UTF-8">
    <title>Acomiadament</title>
</head>

<body>
    <header>
        <h1>Fins a un altre
            <?php echo $usuari; ?>!
        </h1>
    </header>
    <form method="post" action="index.php">
        <button type="submit">Tornar a Inici</button>
    </form>
</body>

</html>