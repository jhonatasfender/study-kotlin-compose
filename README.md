# Study - Kotlin Multiplatform Desktop Application

Este é um projeto Kotlin Multiplatform focado em desenvolvimento Desktop, utilizando Compose Multiplatform para criar interfaces de usuário modernas e responsivas.

## 🚀 Tecnologias Utilizadas

- Kotlin Multiplatform
- Compose Multiplatform
- Gradle
- Kotlin Coroutines
- Kotlin Serialization

## 📁 Estrutura do Projeto

O projeto está organizado da seguinte forma:

```
study/
├── composeApp/           # Código principal da aplicação
│   ├── commonMain/      # Código compartilhado entre todas as plataformas
│   └── desktopMain/     # Código específico para Desktop
├── gradle/              # Configurações do Gradle
└── build.gradle.kts     # Configurações de build do projeto
```

## 🛠️ Configuração do Ambiente

1. Certifique-se de ter o JDK 17 ou superior instalado
2. Clone o repositório
3. Execute o build do projeto:
   ```bash
   ./gradlew build
   ```

## 🎯 Executando o Projeto

Para executar a aplicação em modo de desenvolvimento:

```bash
./gradlew :composeApp:run
```

## 📚 Recursos

- Interface de usuário moderna com Compose Multiplatform
- Arquitetura limpa e modular
- Suporte a temas claro/escuro
- Internacionalização (i18n)

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 📞 Suporte

Para suporte, abra uma issue no repositório do projeto.

* `/composeApp` is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - `commonMain` is for code that's common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple's CoreCrypto for the iOS part of your Kotlin app,
    `iosMain` would be the right folder for such calls.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…