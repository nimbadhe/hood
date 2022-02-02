
REG ADD "HKLM\SYSTEM\CurrentControlSet\Services\LanmanServer\Parameters" /v RequireSecuritySignature /t REG_DWORD /d 1 /F

REG ADD "HKLM\SYSTEM\CurrentControlSet\Control\SecurityProviders\SCHANNEL\Ciphers\Triple DES 168" /v Enabled /t REG_DWORD /d 0 /F
REG ADD "HKLM\SYSTEM\CurrentControlSet\Control\SecurityProviders\SCHANNEL\Ciphers\RC4 128/128" /v Enabled /t REG_DWORD /d 0 /F
REG ADD "HKLM\SYSTEM\CurrentControlSet\Control\SecurityProviders\SCHANNEL\KeyExchangeAlgorithms\Diffie-Hellman" /v Enabled /t REG_DWORD /d 0 /F

REG ADD "HKLM\SYSTEM\CurrentControlSet\Control\SecurityProviders\SCHANNEL\Protocols\TLS 1.0\Client" /v Enabled /t REG_DWORD /d 0 /F
REG ADD "HKLM\SYSTEM\CurrentControlSet\Control\SecurityProviders\SCHANNEL\Protocols\TLS 1.0\Client" /v DisabledByDefault /t REG_DWORD /d 1 /F
REG ADD "HKLM\System\CurrentControlSet\Control\SecurityProviders\SCHANNEL\Protocols\TLS 1.0\Server" /v Enabled /t REG_DWORD /d 0 /F
REG ADD "HKLM\System\CurrentControlSet\Control\SecurityProviders\SCHANNEL\Protocols\TLS 1.0\Server" /v DisabledByDefault /t REG_DWORD /d 1 /F

REG ADD "HKLM\SYSTEM\CurrentControlSet\Control\SecurityProviders\SCHANNEL\Protocols\TLS 1.1\Client" /v Enabled /t REG_DWORD /d 0 /F
REG ADD "HKLM\SYSTEM\CurrentControlSet\Control\SecurityProviders\SCHANNEL\Protocols\TLS 1.1\Client" /v DisabledByDefault /t REG_DWORD /d 1 /F
REG ADD "HKLM\System\CurrentControlSet\Control\SecurityProviders\SCHANNEL\Protocols\TLS 1.1\Server" /v Enabled /t REG_DWORD /d 0 /F
REG ADD "HKLM\System\CurrentControlSet\Control\SecurityProviders\SCHANNEL\Protocols\TLS 1.1\Server" /v DisabledByDefault /t REG_DWORD /d 1 /F

Set-ItemProperty -Path "HKLM:\SYSTEM\CurrentControlSet\Services\PimIndexMaintenanceSvc" -Name "Start" -Value "4" -type "DWord" -Force
Set-ItemProperty -Path "HKLM:\SYSTEM\CurrentControlSet\Services\UserDataSvc" -Name "Start" -Value "4" -type "DWord" -Force
Set-ItemProperty -Path "HKLM:\SYSTEM\CurrentControlSet\Services\UnistoreSvc" -Name "Start" -Value "4" -type "DWord" -Force
Set-ItemProperty -Path "HKLM:\SYSTEM\CurrentControlSet\Services\WpnUserService" -Name "Start" -Value "4" -type "DWord" -Force

mkdir c:\install\BesClient

#Invoke-WebRequest -Uri "https://9020tstwsesa.blob.core.windows.net/besclient/BesClient.zip?sp=r&st=2022-01-14T11:26:05Z&se=2022-11-17T19:26:05Z&spr=https&sv=2020-08-04&sr=b&sig=RO7j6Fk5b7yaCBz%2FRLwXWCT86jaYt4I1nevx1xcw38c%3D" -OutFile "c:\install\BesClient\BesClient.zip"
#Expand-Archive -LiteralPath 'c:\install\BesClient\BesClient.zip' -DestinationPath 'C:\install\BesClient'