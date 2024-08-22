package com.prod.GenZ.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TemplatesService {

    public final String entreprise = "S@M+ & BB2";
    public final String urlConnection = "http://localhost:3000/auth/login";
    public String accountCreated(String nom, String prenom, String login, String password){
        String mssg = """
                <!DOCTYPE html>
                <html>
                <head>
                    <style>
                        body {
                            font-family: Arial, sans-serif;
                            font-size: 14px;
                            line-height: 1.5;
                        }
                                
                        .container {
                            max-width: 600px;
                            margin: 0 auto;
                            padding: 20px;
                            background-color: #f2f2f2;
                            border-radius: 5px;
                        }
                                
                        h2 {
                            color: #333333;
                        }
                                
                        p {
                            margin-bottom: 20px;
                        }
                                
                        .button {
                            display: inline-block;
                            padding: 10px 20px;
                            background-color: #007bff;
                            color: #ffffff;
                            text-decoration: none;
                            border-radius: 5px;
                        }
                                
                        .button:hover {
                            background-color: #0056b3;
                        }
                    </style>
                </head>
                                
                <body>
                    <div class="container">
                        <h2>Compte créé</h2>
                        <p>Cher(e) <b>[nom] [prenom]</b>,</p>
                        <p>Votre compte a été créé avec succès.</p>
                        <p>Merci de nous rejoindre !</p>
                        <p>
                            Login : <b>[login]</b>
                        </p>
                        <p>
                            Mot de passe : <b>[password]</b>
                        </p>
                        <p>
                            Pour commencer, veuillez cliquer sur le bouton ci-dessous pour vous connecter :
                            <br>
                            <a href="[url]" class="button"><span style="color: white;">Se connecter</span></a>
                        </p>
                        <p>Si vous avez des questions, n'hésitez pas à contacter notre équipe d'assistance.</p>
                        <p>Cordialement,<br>[entreprise]</p>
                    </div>
                </body>
                </html>
                """;

        mssg = mssg.replace("[nom]", nom);
        mssg = mssg.replace("[prenom]", prenom);
        mssg = mssg.replace("[login]", login);
        mssg = mssg.replace("[password]", password);
        mssg = mssg.replace("[entreprise]", entreprise);
        mssg = mssg.replace("[url]", urlConnection);

        return  mssg;
    }

    public String accountVerified(String nom, String prenom, String login){
        String mssg = """
                <!DOCTYPE html>
                <html>
                                
                <head>
                    <style>
                        body {
                            margin: 0;
                            padding: 0;
                            background-color: #f8f8f8;
                            font-family: Arial, sans-serif;
                        }
                                
                        .container {
                            max-width: 600px;
                            margin: 0 auto;
                            padding: 40px 20px;
                            background-color: #ffffff;
                            border-radius: 10px;
                            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
                        }
                                
                        h1 {
                            font-size: 24px;
                            color: #333333;
                            margin-bottom: 20px;
                        }
                                
                        p {
                            font-size: 16px;
                            color: #555555;
                            line-height: 1.6;
                            margin-bottom: 16px;
                        }
                                
                        .button {
                            display: inline-block;
                            padding: 12px 24px;
                            background-color: #007bff;
                            color: #ffffff;
                            text-decoration: none;
                            border-radius: 5px;
                            transition: background-color 0.3s;
                        }
                                
                        .button:hover {
                            background-color: #0056b3;
                        }
                    </style>
                </head>
                                
                <body>
                    <div class="container">
                        <h1>Compte validé avec succès !</h1>
                        <p>Bonjour <b>[nom] [prenom]</b>,</p>
                        <p>Nous sommes ravis de vous informer que votre compte a été validé avec succès.</p>
                        <p>Vous êtes maintenant prêt à profiter de tous les avantages de notre service.</p>
                        <p>Merci de nous rejoindre !</p>
                        <p>
                            Login : <b>[login]</b>
                        </p>
                        <p>
                            Mot de passe : <b>[fournit lors de l'inscription]</b>
                        </p>
                        <p>
                            Pour commencer, veuillez cliquer sur le bouton ci-dessous pour vous connecter à votre compte :
                            <br>
                            <a href="[url]" class="button"><span style="color: white;">Se connecter</span></a>
                        </p>
                        <p>Si vous avez des questions ou besoin d'aide, n'hésitez pas à nous contacter.</p>
                        <p>Nous sommes impatients de vous servir !</p>
                        <p>Cordialement,<br>[entreprise]</p>
                    </div>
                </body>
                                
                </html>
                """;

        mssg = mssg.replace("[nom]", nom);
        mssg = mssg.replace("[prenom]", prenom);
        mssg = mssg.replace("[login]", login);
        mssg = mssg.replace("[entreprise]", entreprise);
        mssg = mssg.replace("[url]", urlConnection);

        return  mssg;
    }

    public String demandeLegalisationAccepte(String nom, String prenom, String idDoc, String typeDoc, String dateDemande, String dateTraitement){
        String mssg = """
                <!DOCTYPE html>
                <html>
                                
                <head>
                    <style>
                        body {
                            margin: 0;
                            padding: 0;
                            background-color: #f8f8f8;
                            font-family: Arial, sans-serif;
                        }
                                
                        .container {
                            max-width: 600px;
                            margin: 0 auto;
                            padding: 40px 20px;
                            background-color: #ffffff;
                            border-radius: 10px;
                            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
                        }
                                
                        h1 {
                            font-size: 24px;
                            color: #333333;
                            margin-bottom: 20px;
                        }
                                
                        p {
                            font-size: 16px;
                            color: #555555;
                            line-height: 1.6;
                            margin-bottom: 16px;
                        }
                                
                        .button {
                            display: inline-block;
                            padding: 12px 24px;
                            background-color: #007bff;
                            color: #ffffff;
                            text-decoration: none;
                            border-radius: 5px;
                            transition: background-color 0.3s;
                        }
                                
                        .button:hover {
                            background-color: #0056b3;
                        }
                    </style>
                </head>
                                
                <body>
                    <div class="container">
                        <h1>Validation de votre demande de légalisation de document</h1>
                        <p>Cher(e) <b>[nom] [prenom]</b>,</p>
                        <p>Nous sommes heureux de vous informer que votre demande de légalisation de document a été validée.</p>
                        <p>Veuillez trouver ci-dessous les détails de votre demande :</p>
                                
                        <ul>
                            <li><strong>Type de document :</strong> [typeDoc]</li>
                            <li><strong>Numéro du document :</strong> #[idDoc]</li>
                            <li><strong>Date de la demande :</strong> [dateDemande]</li>
                            <li><strong>Date de validation :</strong> [dateTraitement]</li>
                        </ul>
                                
                        <p>Veuillez se connecter pour accéder à votre document:</p>
                        <a href="[url]" class="button"><span style="color: white;">Se connecter</span></a>
                                
                        <p>Si vous avez des questions ou avez besoin d'assistance supplémentaire, n'hésitez pas à nous contacter.</p>
                        <p>Cordialement,<br>[entreprise]</p>
                    </div>
                </body>
                                
                </html>
                """;

        mssg = mssg.replace("[nom]", nom);
        mssg = mssg.replace("[prenom]", prenom);
        mssg = mssg.replace("[typeDoc]", typeDoc);
        mssg = mssg.replace("[idDoc]", idDoc);
        mssg = mssg.replace("[dateDemande]", dateDemande);
        mssg = mssg.replace("[dateTraitement]", dateTraitement);
        mssg = mssg.replace("[entreprise]", entreprise);
        mssg = mssg.replace("[url]", urlConnection);

        return  mssg;
    }

    public String demandeLegalisationRejetee(String nom, String prenom, String commentAgent, String idDoc, String typeDoc, String dateDemande, String dateTraitement){
        String mssg = """
                <!DOCTYPE html>
                <html>
                                
                <head>
                    <style>
                        body {
                            margin: 0;
                            padding: 0;
                            background-color: #f8f8f8;
                            font-family: Arial, sans-serif;
                        }
                                
                        .container {
                            max-width: 600px;
                            margin: 0 auto;
                            padding: 40px 20px;
                            background-color: #ffffff;
                            border-radius: 10px;
                            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
                        }
                                
                        h1 {
                            font-size: 24px;
                            color: #333333;
                            margin-bottom: 20px;
                        }
                                
                        p {
                            font-size: 16px;
                            color: #555555;
                            line-height: 1.6;
                            margin-bottom: 16px;
                        }
                    </style>
                </head>
                                
                <body>
                    <div class="container">
                        <h1>Rejet de votre demande de légalisation de document</h1>
                        <p>Cher(e) <b>[nom] [prenom]</b>,</p>
                        <p>Nous regrettons de vous informer que votre demande de légalisation de document a été rejetée.</p>
                        <p>Veuillez trouver ci-dessous les détails de votre demande :</p>
                        <ul>
                            <li><strong>Raison du rejet :</strong> [commentAgent]</li>
                            <li><strong>Type de document :</strong> [typeDoc]</li>
                            <li><strong>Numéro du document :</strong> #[idDoc]</li>
                            <li><strong>Date de la demande :</strong> [dateDemande]</li>
                            <li><strong>Date de validation :</strong> [dateTraitement]</li>
                        </ul>
                        <p>Nous comprenons que cela peut être décevant, mais nous vous encourageons à réviser les critères requis et à
                            soumettre une nouvelle demande si vous le souhaitez.</p>
                        <p>Si vous avez des questions ou avez besoin d'informations supplémentaires, n'hésitez pas à nous contacter.</p>
                        <p>Nous vous remercions de votre compréhension.</p>
                        <p>Cordialement,<br>[entreprise]</p>
                    </div>
                </body>
                                
                </html>
                """;

        mssg = mssg.replace("[nom]", nom);
        mssg = mssg.replace("[prenom]", prenom);
        mssg = mssg.replace("[commentAgent]", commentAgent);
        mssg = mssg.replace("[typeDoc]", typeDoc);
        mssg = mssg.replace("[idDoc]", idDoc);
        mssg = mssg.replace("[dateDemande]", dateDemande);
        mssg = mssg.replace("[dateTraitement]", dateTraitement);
        mssg = mssg.replace("[entreprise]", entreprise);
        mssg = mssg.replace("[url]", urlConnection);

        return  mssg;
    }
    public String sendMailReclamationDepose(String nom, String prenom, String sujet){
        String mssg = """
                <!DOCTYPE html>
                <html>
                                
                <head>
                  <style>
                    body {
                      font-family: Arial, sans-serif;
                      background-color: #f5f5f5;
                      padding: 20px;
                    }
                                
                    .container {
                      max-width: 600px;
                      margin: 0 auto;
                      background-color: #ffffff;
                      padding: 40px;
                      border-radius: 5px;
                    }
                                
                    h1 {
                      font-size: 24px;
                      margin-bottom: 20px;
                    }
                                
                    p {
                      margin-bottom: 15px;
                    }
                                
                    .button {
                      display: inline-block;
                      background-color: #007bff;
                      color: #ffffff;
                      padding: 10px 20px;
                      text-decoration: none;
                      border-radius: 4px;
                      transition: background-color 0.3s;
                    }
                                
                    .button:hover {
                      background-color: #0056b3;
                    }
                  </style>
                </head>
                                
                <body>
                  <div class="container">
                    <h1>Validation de votre réclamation</h1>
                    <p>Cher(e) <b>[nom] [prenom]</b>,</p>
                    <p>Nous avons bien reçu votre réclamation concernant "<b>[sujet]</b>"". Votre demande est actuellement
                      en cours de traitement par notre équipe.</p>
                    <p>Un de nos responsables va examiner votre réclamation dans les plus brefs délais et vous fournira une réponse
                      détaillée. Nous mettons tout en œuvre pour résoudre votre problème de manière satisfaisante.</p>
                    <p>Si vous avez des questions supplémentaires ou besoin d'une assistance supplémentaire, n'hésitez pas à nous
                      contacter.</p>
                    <p>Merci pour votre patience et votre compréhension.</p>
                    <p>
                      Veuillez cliquer sur le bouton ci-dessous pour vous connecter à votre compte :
                      <br>
                      <a href="[url]" class="button"><span style="color: white;">Se connecter</span></a>
                                
                    </p>
                    <p>Cordialement,<br>[entreprise]</p>
                    <p>L'équipe de support</p>
                  </div>
                </body>
                                
                </html>
                """;

        mssg = mssg.replace("[nom]", nom);
        mssg = mssg.replace("[prenom]", prenom);
        mssg = mssg.replace("[sujet]", sujet);
        mssg = mssg.replace("[entreprise]", entreprise);
        mssg = mssg.replace("[url]", urlConnection);

        return  mssg;
    }
}
