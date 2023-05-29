<?php
echo "<link rel=stylesheet href=CSS/final.css>";
session_start();
caducarSessio();

if (isset($_SESSION['last_activity']) && (time() - $_SESSION['last_activity'] > 300)) {
    // Si la sesión ha caducado, eliminar todas las variables de sesión y redirigir a inici.php
    session_unset();
    session_destroy();
    header("Location: index.php?caducada");
}

$_SESSION['last_activity'] = time(); // actualizar la última actividad de la sesión

if (!isset($_SESSION['usuari'])) {
    header("Location: index.php");
}

if (isset($_POST['tancar'])) {
    session_unset();
    session_destroy();
    header("Location: acomiadament.php");
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
    <title>Dades del formulari</title>
</head>

<body>
    <header>
        <h1>Benvingut,
            <?php echo $_SESSION['usuari']; ?>
        </h1>
        <form method="post" action="acomiadament.php">
            <button type="submit" name="tancar">Tancar Sessió</button>
        </form>
    </header>
    <main>
        <h2>Dades introduïdes o seleccionades:</h2>
        <p><strong>Correu electrònic:</strong>
            <?php echo $_SESSION['email']; ?>
        </p>
        <p><strong>Data:</strong>
            <?php echo $_SESSION['date']; ?>
        </p>
        <p><strong>Opció seleccionada:</strong>
            <?php echo $_SESSION['radio']; ?>
        </p>
    </main>
</body>

</html>