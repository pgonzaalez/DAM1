<?php
echo "<link rel=stylesheet href=CSS/index.css>";
session_start();
caducarSessio();

if (isset($_SESSION['usuari']) && isset($_SESSION['contrasenya'])) {
    header('Location: formulari.php');
    exit;
}

if (isset($_POST['enviar'])) {
    if ($_POST['usuari'] == 'admin' && $_POST['contrasenya'] == 'admin') {
        $_SESSION['usuari'] = $_POST['usuari'];
        $_SESSION['contrasenya'] = $_POST['contrasenya'];
        header('Location: formulari.php');
        exit;
    } else {
        $missatge = 'L\'usuari o contrasenya no són vàlids.';
    }
}
?>
<?php

function verificarCorreu($email) {
  if(!filter_var($email, FILTER_VALIDATE_EMAIL)) {
    return false;
  }
  return true;
}

function tancarSessio() {
  session_unset();
  session_destroy();
  header('Location: acomiadament.php');
  exit();
}

function caducarSessio() {
  $inactivitat = 300; 
  if(isset($_SESSION['temps']) && (time() - $_SESSION['temps']) > $inactivitat) {
    session_unset();
    session_destroy();
    header('Location: index.php?caducada=true');
    exit();
  }
  $_SESSION['temps'] = time();
}

?>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" src="CSS/index.css">
    <title>Login</title>
   
</head>
<body>
    <h1>Inici de sessió</h1>
    <?php if (isset($missatge)): ?>
        <p style="color:red;">
            <?php echo $missatge; ?>
        </p>
    <?php endif; ?>
    <form method="post">
        <label>Nom d'usuari:</label>
        <input type="text" name="usuari" required><br>
        <label>Contrasenya:</label>
        <input type="password" name="contrasenya" required><br><br>
        <input type="submit" name="enviar" value="Iniciar sessió">
    </form>
</body>
</html>