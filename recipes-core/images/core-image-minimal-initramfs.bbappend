# Make initramfs compatible with ARM
INITRAMFS_SCRIPTS:remove = "\
    initramfs-module-setup-live \
    initramfs-module-install \
    initramfs-module-install-efi \
"

INITRAMFS_SCRIPTS:append = "\
    initramfs-module-nfsrootfs \
    initramfs-module-ecm \
"
