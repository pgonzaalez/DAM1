<?php
echo "<link rel=stylesheet href=CSS/formulari.css>";
session_start();
caducarSessio();

if (!isset($_SESSION['usuari']) || !isset($_SESSION['contrasenya'])) {
    header('Location: index.php');
    exit();
}

if (isset($_POST['enviar'])) {
    $email = $_POST['email'];
    $date = $_POST['date'];
    $radio = $_POST['radio'];
    $checkbox = isset($_POST['checkbox']) ? $_POST['checkbox'] : array();
    $select = isset($_POST['select']) ? $_POST['select'] : array();

    if (verificarCorreu($email)) {
        $_SESSION['email'] = $email;
        $_SESSION['date'] = $date;
        $_SESSION['radio'] = $radio;
        $_SESSION['checkbox'] = $checkbox;
        $_SESSION['select'] = $select;
        header('Location: final.php');
        exit();
    } else {
        $error = "L'adreça de correu no és correcta.";
    }
}
function verificarCorreu($email) {
    if(!filter_var($email, FILTER_VALIDATE_EMAIL)) {
      return false;
    }
    return true;
  }
function caducarSessio() {
    $inactivitat = 15;
    if (isset($_SESSION['temps']) && (time() - $_SESSION['temps']) > $inactivitat) {
        session_unset();
        session_destroy();
        header('Location: index.php?caducada=true');
        exit();
    }
    $_SESSION['temps'] = time();
}

function tancarSessio() {
    session_unset();
    session_destroy();
    header('Location: acomiadament.php');
    exit();
  }

if (isset($_SESSION['last_activity']) && (time() - $_SESSION['last_activity'] > 300)) {
    session_unset();
    session_destroy();
    header("Location: index.php?caducada");
    exit();
}

$_SESSION['last_activity'] = time();

if (!isset($_SESSION['usuari'])) {
    header("Location: index.php");
    exit();
}

if (isset($_POST['tancar'])) {
    tancarSessio();
    exit();
}
?>

<!DOCTYPE html>
<html lang="ca">

<head>
    <meta charset="UTF-8">
    <title>Formulari</title>
</head>

<body>
    <header>
        <h1>Benvingut,
            <?php echo $_SESSION['usuari']; ?>
        </h1>
    </header>
    <form method="post" action="acomiadament.php">
    <input type="submit" name="enviar" value="Tancar sessió">
    </form>

    <?php if (isset($error)): ?>
        <p style="color:red;">
            <?php echo $error; ?>
        </p>
    <?php endif; ?>

    <form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
        <label for="email">Correu electrònic:</label>
        <input type="text" name="email" id="email" value="<?php echo isset($_SESSION['email']) ? $_SESSION['email'] : ''; ?>"><br><br>
        <label for="date">Data:</label>
        <input type="date" name="date" id="date" value="<?php echo isset($_SESSION['date']) ? $_SESSION['date'] : ''; ?>"><br><br>

        <fieldset>
            <legend>Sexe:</legend>
            <label><input type="radio" name="radio" value="radio1" <?php if (isset($_SESSION['radio']) && $_SESSION['radio'] == 'radio1')
                echo 'checked'; ?>>Home</label><br>
            <label><input type="radio" name="radio" value="radio2" <?php if (isset($_SESSION['radio']) && $_SESSION['radio'] == 'radio2')
                echo 'checked'; ?>>Dona</label><br>
            <label><input type="radio" name="radio" value="radio3" <?php if (isset($_SESSION['radio']) && $_SESSION['radio'] == 'radio3')
                echo 'checked'; ?>>No binari</label><br>
            <label><input type="radio" name="radio" value="radio4" <?php if (isset($_SESSION['radio']) && $_SESSION['radio'] == 'radio4')
                echo 'checked'; ?>>Altre</label><br>
        </fieldset><br>

        <fieldset>
            <legend>Menjar:</legend>
            <label><input type="checkbox" name="checkbox[]" value="check1" <?php if (isset($_SESSION['checkbox']) && in_array('check1', $_SESSION['checkbox']))
                echo 'checked'; ?>>Macarrons</label><br>
            <label><input type="checkbox" name="checkbox[]" value="check2" <?php if (isset($_SESSION['checkbox']) && in_array('check2', $_SESSION['checkbox']))
                echo 'checked'; ?>>Pizza</label><br>
            <label><input type="checkbox" name="checkbox[]" value="check3" <?php if (isset($_SESSION['checkbox']) && in_array('check3', $_SESSION['checkbox']))
                echo 'checked'; ?>>Patates fregides</label><br>
            <label><input type="checkbox" name="checkbox[]" value="check4" <?php if (isset($_SESSION['checkbox']) && in_array('check4', $_SESSION['checkbox']))
                echo 'checked'; ?>>Carn a la brasa</label><br>
            <label><input type="checkbox" name="checkbox[]" value="check5" <?php if (isset($_SESSION['checkbox']) && in_array('check5', $_SESSION['checkbox']))
                echo 'checked'; ?>>Canalons</label><br>
        </fieldset><br>

        <label for="select">Com vols pagar?:</label>
        <select name="select[]" id="select" multiple>
            <option value="option1" <?php if (isset($_SESSION['select']) && in_array('option1', $_SESSION['select']))
                echo 'selected'; ?>>Efectiu</option>
            <option value="option2" <?php if (isset($_SESSION['select']) && in_array('option2', $_SESSION['select']))
                echo 'selected'; ?>>Paypal</option>
            <option value="option3" <?php if (isset($_SESSION['select']) && in_array('option3', $_SESSION['select']))
                echo 'selected'; ?>>Tarjeta bancaria</option>
            <option value="option4" <?php if (isset($_SESSION['select']) && in_array('option4', $_SESSION['select']))
                echo 'selected'; ?>>Paysafecard</option>
            <option value="option5" <?php if (isset($_SESSION['select']) && in_array('option5', $_SESSION['select']))
                echo 'selected'; ?>>Altres</option>
        </select><br><br>

        <input type="submit" name="enviar" value="Enviar">
    </form>
</body>
</html>
