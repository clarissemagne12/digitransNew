# Documentation technique

## 1. Présentation du projet
application de gestion d'une restauration.
Il permet de digitaliser et d’automatiser les processus liés à la gestion de restauration

## 2. Technologies utilisées
- Spring Boot
- MySQL
- JWT
- Docker

## 3. Architecture
Backend REST API + Base de données MySQL


### Description :
- **Controller** : expose les API REST
- **Service** : contient la logique métier
- **Repository** : accès aux données via JPA
- **Database** : stockage des données

---

## 2.3 Architecture de sécurité

La sécurité est assurée par **Spring Security + JWT** :


### Rôles :
- ADMIN

---

# 3. Choix technologiques

| Technologie | Utilisation |
|------------|-------------|
| Java 21 | Langage backend |
| Spring Boot | Framework principal |
| Spring Security | Sécurité |
| JWT | Authentification stateless |
| Spring Data JPA | ORM |
| MySQL | Base de données |
| Maven | Gestion des dépendances |
| Docker | Conteneurisation |
| Git/GitHub | Versioning |
| Postman | Test des API |

---

## 3.1 Justification des choix

### Spring Boot
- Développement rapide
- Architecture propre
- Très utilisé en entreprise

### JWT
- Sécurisation sans session serveur
- Adapté aux API REST

### MySQL
- Base relationnelle fiable
- Adaptée aux données structurées 

### Docker
- Déploiement portable
- Environnements identiques (dev/prod)

---

# 4. Structure du projet



---

# 5. Procédure de déploiement

## 5.1 Prérequis

- Java 25
- Maven
- MySQL
- Github
- Docker (recommandé)



---

## 5.2 Déploiement local

### 1. Cloner le projet

```bash
git clone https://github.com/clarissemagne12/digitransNew.git
cd digitransNew

### Cloner le projet
```bash
https://github.com/clarissemagne12/digitransNew